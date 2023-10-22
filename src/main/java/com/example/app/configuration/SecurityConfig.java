package com.example.app.configuration;


//import com.example.app.auth.PrincipalDetailsService;
import com.example.app.auth.PrincipalDetailsService;
import com.example.app.auth.loginHandler.CustomAuthenticationFailureHandler;
import com.example.app.auth.loginHandler.CustomAuthenticationSuccessHandler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;
import java.security.Principal;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PrincipalDetailsService principalDetailsService;

    @Autowired
    private CustomAuthenticationSuccessHandler successHandler;

    @Autowired
    private CustomAuthenticationFailureHandler failureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception{


        http
                .authorizeRequests()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/css/**", "/js/**", "/image/**").permitAll()
                .antMatchers("/**").permitAll()
//                .antMatchers("/", "/member/**", "/main", "/member/join","/member/login").permitAll()
//                .antMatchers("/admintest/**","/mainImage/**").permitAll()
//                .antMatchers("/movielist/**").permitAll()
//                .antMatchers("/reservation/**").permitAll()
////                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/admin/**").permitAll()
//                .anyRequest().authenticated()
                .and()

                .formLogin()
                .loginPage("/security/login")
                .loginProcessingUrl("/security/login")
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .usernameParameter("userId")
                .passwordParameter("userPw")
                .defaultSuccessUrl("/main")
                .permitAll()
                .and()

                .logout()
                .logoutUrl("/member/logout")
                .logoutSuccessUrl("/main")
                .permitAll();

        http.csrf().disable();
    }

}
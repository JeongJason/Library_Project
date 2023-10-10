package com.example.app.configuration;


import com.example.app.auth.LoginIdPwValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final LoginIdPwValidator loginIdPwValidator;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()					// .요청 설정할게요.
                .antMatchers("/**").permitAll();
//                .antMatchers("/chk").permitAll()    // 로그인 인증이 필요없는 URI
//                .antMatchers("/user").hasAuthority("USER")
//                .antMatchers("/manage").hasAuthority("ROLE_ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("view/login")
//                .loginProcessingUrl("/loginProc")
//                .usernameParameter("uId")
//                .passwordParameter("uPw")
//                .defaultSuccessUrl("/", true) // 로그인후 이동하는 URI
//                .permitAll()
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/lgoutProc"));
    }
    // CSS 와 IMG파일등은 인증없이 보일수있게 하기위한 메서드
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/js/**","/static/css/**","/static/img/**","/static/frontend/**");
    }

    // 로그인시 유저가 id/pw를 입력한후 form이 발송되면 아래메소드를 통해 클래스로 id가 넘어가 비교하게된다.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginIdPwValidator);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

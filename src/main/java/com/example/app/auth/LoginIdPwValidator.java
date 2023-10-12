package com.example.app.auth;

import com.example.app.domain.dto.UserDTO;
import com.example.app.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginIdPwValidator implements UserDetailsService {
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String insertedId) throws UsernameNotFoundException {
        UserDTO userDTO = userMapper.findByUid(insertedId);

        if(userDTO == null){
            return null;
        }
        String pw = userDTO.getUserPw();
        String roles = userDTO.getUserRole();
        return User.builder()
                .username(insertedId)
                .password(pw)
                .roles(roles)
                .build();

    }
}

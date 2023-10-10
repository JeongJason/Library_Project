package com.example.app.auth;

import com.example.app.domain.dto.UserDTO;
import com.example.app.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.rmi.server.UID;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String uId) throws UsernameNotFoundException {

        UserDTO userDTO = userMapper.select(uId);

        if (userDTO == null) {
            throw new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다: " + uId);
        }

        // PrincipalDetails 클래스의 생성자를 UserDTO를 받도록 수정
        return new PrincipalDetails(userDTO);
    }
}

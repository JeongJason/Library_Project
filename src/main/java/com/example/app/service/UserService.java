package com.example.app.service;

import com.example.app.domain.dto.UserDTO;
import com.example.app.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    private boolean isAdmin(){
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
    }

    // 회원 조회
    public UserDTO getUser(String userId) {
        return userMapper.findByUid(userId);
    }

    // 회원 목록 조회
    public List<UserDTO> getAllUser() {
        // 권한 확인 로직 (여기서는 예시로 ROLE_ADMIN을 가진 사용자만 조회 가능하도록)
        if (!isAdmin()) {
            throw new AccessDeniedException("권한이 없습니다.");
        }
        return userMapper.findAll();
    }

    // 회원 등록
    public void write(UserDTO userDTO) {
        userMapper.register(userDTO);
    }

    // 회원 삭제
    public void delete(String uId) {
        userMapper.delete(uId);
    }

    // 회원 정보 수정
    @Transactional
    public void modify(UserDTO userDTO) {
        userMapper.update(userDTO);
    }


    // 비밀번호 조회
    public String getUserPW(String userId){
        return userMapper.findPW(userId);
    }
    // 비밀번호 변경
    public void updatePW(String userId,String userPw){
        userMapper.updatePW(userId, userPw);
    }
}
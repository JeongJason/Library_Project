package com.example.app.service;

import com.example.app.domain.dao.UserDAO;
import com.example.app.domain.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDAO userDAO;

    // 회원 조회
    public UserDTO getUser(String uId) {
        return userDAO.findById(uId);
    }

    // 회원 목록 조회
    public List<UserDTO> getList() {
        return userDAO.findAll();
    }

    // 회원 등록
    public void write(UserDTO userDTO) {
        userDAO.save(userDTO);
    }

    // 회원 삭제
    public void delete(String uId) {
        userDAO.delete(uId);
    }

    // 회원 정보 수정
    public void modify(UserDTO userDTO) {
        userDAO.setUser(userDTO);
    }
}

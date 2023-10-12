package com.example.app.domain.dao;

import com.example.app.domain.dto.UserDTO;
import com.example.app.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;

    // 회원 조회
    public UserDTO findById(String uId){
        return userMapper.select(uId);
    }

    // 회원 목록 조회
    public List<UserDTO> findAll(){
     return userMapper.selectAll();
    }

    // 회원 등록
    public void save(UserDTO userDTO){
        userMapper.insert(userDTO);
    }

    // 회원 삭제
    public void delete(String uId){
        userMapper.delete(uId);
    }

    // 회원 정보 수정
    public void setUser(UserDTO userDTO){
        userMapper.update(userDTO);
    }
}

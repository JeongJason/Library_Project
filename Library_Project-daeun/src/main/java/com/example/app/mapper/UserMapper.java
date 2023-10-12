package com.example.app.mapper;

import com.example.app.domain.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    // 회원 조회
    public UserDTO select(String uId);

    // 회원 목록 조회
    public List<UserDTO> selectAll();

    // 회원 등록
    public void insert(UserDTO userDTO);

    // 회원 삭제
    public void delete(String uId);

    // 회원 정보 수정
    public void update(UserDTO userDTO);

}

package com.example.app.mapper;

import com.example.app.domain.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class UserMapperTests {
    @Autowired
    UserMapper userMapper;

    @Test
    public void selectTest(){
        assertThat(userMapper.select("testuser").getUEmail()).isEqualTo("test@test.com");
    }

    @Test
    public void selectAllTest(){
//        List<UserDTO> users = userMapper.selectAll();
//        for (UserDTO user : users) {
//            System.out.println("User ID: " + user.getUId());
//            System.out.println("User Email: " + user.getUEmail());
//
//        }
        assertThat(userMapper.selectAll().size()).isEqualTo(3);
    }

    @Test
    public void insertTest(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUId("HDE1111");
        userDTO.setUPw("love1111");
        userDTO.setUEmail("lovedaeun@Hwang.com");
        userDTO.setUBirth("1998-11-11");
        userDTO.setURole("executive");

        userMapper.insert(userDTO);

        assertThat(userDTO.getUId()).isEqualTo("HDE1111");
    }

    @Test
    public void updateTest(){
        UserDTO userDTO = userMapper.select("HDE1111");
        userDTO.setUId("HDE1111");
        userDTO.setUPw("cutydaeun");
        userDTO.setUEmail("lovelydaeun@Hwang.com");
        userDTO.setUBirth("1998-11-11");
        userDTO.setURole("executive");
        userMapper.update(userDTO);
//      여기서 그냥 하나만 바꾸고 싶어서 하나면 테스트하면 에러뜸... 왜그렇지...?
    }

    @Test
    public void deleteTest(){
        userMapper.delete("testmem");
    }
}

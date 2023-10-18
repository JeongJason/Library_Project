package com.example.app.mapper;

import com.example.app.domain.dto.WishDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class WishMapperTests {

    @Autowired
    WishMapper wishMapper;

//    @Test
//    public void insertTest(){
//        WishDTO wishDTO = new WishDTO();
//        wishDTO.setWishTitle("세이노의 가르침");
//        wishDTO.setWishAuthor("세이노");
//        wishDTO.setWishPublisher("데이원");
//        wishDTO.setWishYear(2023);
//        wishDTO.setWishIsbn("9791168473690");
//        wishDTO.setUserId("LCJ1111");
//        wishMapper.insert(wishDTO);
//
//        assertThat(wishDTO.getWishTitle()).isEqualTo("세이노의 가르침");
//    }
//
//    @Test
//    public void selectTest(){
//        assertThat(wishMapper.select(1L).getWishTitle()).isEqualTo("타이탄의 도구들");    }
//
//    @Test
//    public void selectAllTests(){
//        assertThat(wishMapper.selectAll().size()).isEqualTo(2);    }
//
//    @Test
//    public void updateTest(){
//        WishDTO wishDTO = wishMapper.select(2L);
//        wishDTO.setWishTitle("세이노의 가르침");
//        wishDTO.setWishAuthor("세이노");
//        wishDTO.setWishPublisher("데이원");
//        wishDTO.setWishYear(2023);
//        wishDTO.setWishIsbn("9791168473690");
//        wishDTO.setWishNote("세이노의 가르침 신청이요~~");
//
//        wishMapper.update(wishDTO);
//    }
//
//    @Test
//    public void deleteTest(){
//        wishMapper.delete(3L);
//    }

}

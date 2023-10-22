package com.example.app.mapper;

import com.example.app.domain.dto.BookDTO;
import com.example.app.domain.dto.LendDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class LendMapperTests {
    @Autowired
    LendMapper lendMapper;

    @Test
    public void insertTest(){
        LendDTO lendDTO = new LendDTO();
        lendDTO.setIsbn("test1s112");
        lendDTO.setUserId("use2sr1");
        lendMapper.insert(lendDTO);
    }

    @Test
    public void selectTest() {
        assertThat(lendMapper.selectByIsbn("CD0000000040").size()).isEqualTo(2);
    }

    @Test
    public void deleteTest(){
        lendMapper.delete(2l);
    }

    @Test
    public void updateTest(){
        LendDTO lendDTO = new LendDTO();
        lendDTO.setLendSeq(5l);
        lendMapper.update(lendDTO);
        LendDTO updatedLendDTO = lendMapper.selectByLendSeq(5l);
        assertThat(lendDTO).isNotNull();
    }

}

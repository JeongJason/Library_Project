package com.example.app.mapper;

import com.example.app.domain.dto.BoardDTO;
import com.example.app.domain.dto.BookDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class BoardMapperTests {

    @Autowired
    BoardMapper boardMapper;

    @Test
    public void selectTest(){
        assertThat(boardMapper.select(1).getAnTitle()).isEqualTo("테스트 제목");
    }

    @Test
    public void selectAllTest(){
        assertThat(boardMapper.selectAll().size()).isEqualTo(3);
    }

    @Test
    public void insertTest(){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setAnTitle("정재원");
        boardDTO.setUserId("Jason");
        boardDTO.setAnContent("황대은 돼지");
        boardMapper.insert(boardDTO);

        assertThat(boardDTO.getAnTitle()).isEqualTo("정재원");
    }

    @Test
    public void updateTest(){
        BoardDTO boardDTO = boardMapper.select(4);
        boardDTO.setAnTitle("황댜은");
        boardMapper.update(boardDTO);

    }

    @Test
    public void deleteTest(){
        boardMapper.delete(5);
    }


}

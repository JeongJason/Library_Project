package com.example.app.mapper;

import com.example.app.domain.dto.BoardDTO;
import com.example.app.domain.paging.Criteria;
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
        assertThat(boardMapper.select(1L).getAnTitle()).isEqualTo("테스트 제목");
    }

/*    @Test
    public void selectAllTest(){
        Criteria criteria = new Criteria();
        assertThat(boardMapper.selectAll(criteria).size()).isEqualTo(3);*/
//    }

    @Test
    public void insertTest(){
        BoardDTO boardDto = new BoardDTO();
        boardDto.setAnTitle("황다은");
        boardDto.setUserId("HDE1234");
        boardDto.setAnContent("정재원 돼지");
        boardMapper.insert(boardDto);

        assertThat(boardDto.getAnTitle()).isEqualTo("황다은")  ;
    }

    @Test
    public void updateTest(){
        BoardDTO boardDTO = boardMapper.select(4L);
        boardDTO.setAnTitle("정재워니");
        boardDTO.setAnContent("하기싫으다..");
        boardMapper.update(boardDTO);
    }

    @Test
    public void deleteTest(){
        boardMapper.delete(4L);
    }

}

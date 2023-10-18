package com.example.app.mapper;

import com.example.app.domain.dto.BookDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.print.Book;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class BookMapperTests {

    @Autowired
    BookMapper bookMapper;

    @Test
    public void selectTest(){
        assertThat(bookMapper.select("CD0000014918").getBookTitle()).isEqualTo("Rain(Rain)");

    }

//    @Test
//    public void selectAllTest(){
//        assertThat(bookMapper.selectAll().size()).isEqualTo(41458);
//    }

    @Test
    public void insertTest(){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setIsbn("test1111");
        bookDTO.setBookTitle("테스트 도서");
        bookDTO.setAuthor("테스트 저자");
        bookDTO.setPublisher("테스트 출판사");
        bookDTO.setPubYear(2023);
        bookMapper.insert(bookDTO);

        assertThat(bookDTO.getIsbn()).isEqualTo("test1111");
    }

    @Test
    public void updateTest(){
        BookDTO bookDTO = bookMapper.select("test1111");
        bookDTO.setBookTitle("수정된 테스트 도서");
        bookMapper.update(bookDTO);
    }

    @Test
    public void deleteTest(){
        bookMapper.delete("test1111");
    }

}

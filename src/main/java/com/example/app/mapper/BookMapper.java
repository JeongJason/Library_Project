package com.example.app.mapper;

import com.example.app.domain.dto.BookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    //    도서 조회
    public BookDTO select(String isbn);
    //    도서 목록 조회
    public List<BookDTO> selectAll();
    //    도서 추가
    public void insert(BookDTO bookDTO);
    //    도서 삭제
    public void delete(String isbn);
    //    도서 수정
    public void update(BookDTO bookDTO);
}

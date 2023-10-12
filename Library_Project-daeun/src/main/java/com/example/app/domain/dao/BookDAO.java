package com.example.app.domain.dao;

import com.example.app.domain.dto.BookDTO;
import com.example.app.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookDAO {
    private final BookMapper bookMapper;

    //    도서 조회
    public BookDTO findById(String isbn){
        return bookMapper.select(isbn);
    }
    //    도서 목록 조회
    public List<BookDTO> findAll(){
        return bookMapper.selectAll();
    }
    //    도서 추가
    public void save(BookDTO bookDTO){
        bookMapper.insert(bookDTO);
    }
    //    도서 삭제
    public void delete(String isbn){
        bookMapper.delete(isbn);
    }
    //    도서 수정
    public void setBook(BookDTO bookDTO){
        bookMapper.update(bookDTO);
    }

}

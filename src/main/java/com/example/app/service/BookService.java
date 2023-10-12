package com.example.app.service;

import com.example.app.domain.dao.BookDAO;
import com.example.app.domain.dto.BookDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookDAO bookDAO;

    //    도서 조회
    public BookDTO getBook(String isbn){
        return bookDAO.findById(isbn);
    }
    //    도서 목록 조회
    public List<BookDTO> getList(){
        return bookDAO.findAll();
    }
    //    도서 추가
    public void write(BookDTO bookDTO){
        bookDAO.save(bookDTO);
    }
    //    도서 삭제
    public void remove(String isbn){
        bookDAO.delete(isbn);
    }
    //    도서 수정
    public void modify(BookDTO bookDTO){
        bookDAO.setBook(bookDTO);
    }
}

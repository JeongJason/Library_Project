package com.example.app.service;

import com.example.app.domain.dao.BoardDAO;
import com.example.app.domain.dto.BoardDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardDAO boardDAO;

    // 게시글 조회
    public BoardDTO getBoard(int anId){
        return boardDAO.findbyId(anId);
    }
    // 게시글 목록
    public List<BoardDTO> getList(){
        return boardDAO.findAll();
    }
    // 게시글 추가
    public void write(BoardDTO boardDTO){
        boardDAO.save(boardDTO);
    }
    // 게시글 삭제
    public void delete(int anId){
        boardDAO.delete(anId);
    }
    // 게시글 수정
    public void modify(BoardDTO boardDTO){
        boardDAO.setBoard(boardDTO);
    }
}

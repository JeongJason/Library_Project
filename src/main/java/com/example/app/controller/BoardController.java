package com.example.app.controller;

import com.example.app.domain.dto.BoardDTO;
import com.example.app.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/boards/*")
public class BoardController {
    private final BoardService boardService;

    // 게시글 조회
    public BoardDTO getBoard(int anId){
        return boardService.getBoard(anId);
    }
    // 게시글 목록
    public List<BoardDTO> getList(){
        return boardService.getList();
    }
    // 게시글 추가
    public void write(BoardDTO boardDTO){
        boardService.write(boardDTO);
    }
    // 게시글 삭제
    public void remove(int anId){
        boardService.delete(anId);
    }
    // 게시글 수정
    public void modify(BoardDTO boardDTO){
        boardService.modify(boardDTO);
    }
}

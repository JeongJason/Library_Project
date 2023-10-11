package com.example.app.controller;

import com.example.app.domain.dto.BoardDTO;
import com.example.app.domain.paging.Criteria;
import com.example.app.domain.paging.PageMakerDTO;
import com.example.app.service.BoardService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/notice")
    public void showList(Criteria criteria,Model model){
        model.addAttribute("list", boardService.getList(criteria));
        Long total = boardService.getTotal();
        PageMakerDTO pageMaker = new PageMakerDTO(criteria, total);

        Long totalPostCount = boardService.getTotal();
        model.addAttribute("totalPostCount", totalPostCount);
        model.addAttribute("pageMaker", pageMaker);
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

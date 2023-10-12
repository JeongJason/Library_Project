package com.example.app.controller;

import com.example.app.domain.dto.BoardDTO;
import com.example.app.domain.dto.Search;
import com.example.app.domain.paging.Criteria;
import com.example.app.domain.paging.PageMakerDTO;
import com.example.app.service.BoardService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
    public void showList(Search search ,Criteria criteria, Model model){
        model.addAttribute("list", boardService.getList(criteria, search));
        Long total = boardService.getTotal(search);
        PageMakerDTO pageMaker = new PageMakerDTO(criteria, total);

        Long totalPostCount = boardService.getTotal(search);
        model.addAttribute("totalPostCount", totalPostCount);
        model.addAttribute("pageMaker", pageMaker);
    }
    // 게시글 추가
    @GetMapping("/write")
    public String showwrite(Model model){
        model.addAttribute(new BoardDTO());
        return "/boards/3-3write";
    }

    @PostMapping("/write")
    public RedirectView write(BoardDTO boardDTO, RedirectAttributes redirectAttributes){
        boardService.write(boardDTO);
        redirectAttributes.addFlashAttribute("anId", boardDTO.getAnId());
        return new RedirectView("/boards/notice");
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

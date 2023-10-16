package com.example.app.controller;

import com.example.app.domain.dto.BoardDTO;
import com.example.app.domain.dto.ReviewDTO;
import com.example.app.domain.dto.Search;
import com.example.app.domain.paging.Criteria;
import com.example.app.domain.paging.PageMakerDTO;
import com.example.app.service.BoardService;
import com.example.app.service.ReviewService;
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
@RequestMapping("/reviews/*")
public class ReviewController {
    private final ReviewService reviewService;

    // 게시글 조회
    @GetMapping(value={"/3-7post","/3-8modify"})
    public void getBoard(Search search, Criteria criteria, Long revId, Model model) {
        model.addAttribute(reviewService.getBoard(revId));
    }

    // 게시글 목록
    @GetMapping("/3-2review")
    public void showList(Search search,  Criteria criteria, Model model){
        System.out.println("GET /reviews/3-2review..."+search);
        List<ReviewDTO> list = reviewService.getList(criteria, search);
        model.addAttribute("list", list);
        Long total = reviewService.getTotal(search);
        System.out.println("Count : " + total);

        PageMakerDTO pageMaker = new PageMakerDTO(criteria, total);

        Long totalPostCount = reviewService.getTotal(search);
        model.addAttribute("totalPostCount", totalPostCount);
        model.addAttribute("pageMaker", pageMaker);
    }
    // 게시글 추가
    @GetMapping("/write")
    public String showwrite(Model model){
        model.addAttribute(new ReviewDTO());
        return "/reviews/3-6write";
    }

    @PostMapping("/write")
    public RedirectView write(ReviewDTO reviewDTO, RedirectAttributes redirectAttributes){
        reviewService.write(reviewDTO);
        redirectAttributes.addFlashAttribute("revId", reviewDTO.getRevId());
        return new RedirectView("/reviews/3-2review");
    }

    // 게시글 삭제
    @GetMapping("/remove")
    public RedirectView remove(Long revId){
        reviewService.delete(revId);
        return new RedirectView("/reviews/3-2review");
    }
    // 게시글 수정
    @PostMapping("/3-8modify")
    public RedirectView modify(Criteria criteria, Search search, ReviewDTO reviewDTO, RedirectAttributes redirectAttributes) {
        reviewService.modify(reviewDTO);
        redirectAttributes.addAttribute("revId", reviewDTO.getRevId());
        redirectAttributes.addFlashAttribute(criteria);
        redirectAttributes.addFlashAttribute(search);
        return  new RedirectView("/reviews/3-7post");
    }
}

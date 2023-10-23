package com.example.app.controller;

import com.example.app.domain.dto.WishDTO;
import com.example.app.service.WishService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@AllArgsConstructor
@RequestMapping("/books/*")
public class WishController {
    private final WishService wishService;

    // 신청 내역 목록
//    @GetMapping("")
//    public void showList(Model model) {
//        model.addAttribute("wish",wishService.getList());}

    // 신청 내역 조회
//    @GetMapping("")/*조회랑 수정*/
//    public void getWish(Long wishId, Model model) {
//        model.addAttribute(wishService.getWish(wishId));
//    }

    // 도서 신청페이지 이동
    @GetMapping("/hopeadd")
    public String showwrite(Model model){
        model.addAttribute(new WishDTO());
        return "books/1-5hopeadd";  /*신청페이지*/
    }

    // 도서 신청 추가
    @GetMapping("/wish")
    public String getWishForm(Model model) {
        model.addAttribute("wishDTO", new WishDTO());
        return "books/1-5hopeadd";
    }
    @PostMapping("/wish")
    public RedirectView write(WishDTO wishDTO, RedirectAttributes redirectAttributes){
        wishService.write(wishDTO);
        System.out.println(wishDTO.toString());
        redirectAttributes.addFlashAttribute("wishId", wishDTO.getWishId());
        return new RedirectView("/books/wish");    /*희망도서신청내역으로*/
    }
//
//    // 도서 신청 내역 삭제
//    @GetMapping("")
//    public RedirectView remove(Long wishId){
//        wishService.remove(wishId);
//        return new RedirectView("/1-3hope");
//    }
//
//    // 도서 신청 내역 수정
//    @PostMapping("")
//    public void modify(WishDTO wishDTO){wishService.modify(wishDTO);}


}
package com.example.app.controller;

import com.example.app.domain.dto.UserDTO;
import com.example.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user/*")
public class UserController {
    private final UserService userService;

    /*
     * Task			URL					Method			Parameter			Form            URL 이동
     *
     * 전체 목록		/user/list			GET
     * 등록 처리		/user/write		    POST			모든 항목				입력화면 필요			이동
     * 조회			/user/read		    GET				uId
     * 삭제 처리		/user/remove		GET				uId				    입력화면 필요			이동
     * 수정 처리		/user/modify		POST			모든 항목				입력화면 필요			이동
     */

    // 회원 목록
    @GetMapping("list")
    public void showList(Model model){
        model.addAttribute(userService.getList());
    }

    // 회원 조회,(&수정페이지로 갈 때)
    @GetMapping(value = {"read","modify"})
    public void getUser(String uId, Model model){
        model.addAttribute(userService.getUser(uId));
    }

    // 회원 추가
    @PostMapping("write")
    public RedirectView write(UserDTO userDTO, RedirectAttributes rttr){
        userService.write(userDTO);
        rttr.addFlashAttribute("uId", userDTO.getUId());
//        추가후 새로고침을해도 redirect로 인해 list로 가더라도 계속 추가되지않는다.
        return new RedirectView("/user/list");
    }

    // 회원 삭제
    @GetMapping("remove")
    public RedirectView remove(String uId){
        userService.delete(uId);
        return new RedirectView("/user/list");
    }

    // 회원 수정
    @PostMapping("modify")
    public RedirectView modify(UserDTO userDTO, RedirectAttributes rttr){
        userService.modify(userDTO);
        rttr.addAttribute("uId", userDTO.getUId());
        return new RedirectView("/user/read");
    }

}

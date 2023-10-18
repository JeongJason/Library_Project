package com.example.app.controller;

import com.example.app.auth.PrincipalDetails;
import com.example.app.domain.dto.BookDTO;
import com.example.app.domain.dto.UserDTO;
import com.example.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/all")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping(value={"/read","/5-1myInfo"})
    public UserDTO getUser(Principal principal, Model model){
        System.out.println(principal);
        model.addAttribute("principal", principal);
        return userService.getUser(principal.getName());
    }

    //    회원가입 창으로 이동
    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("userDTO", new UserDTO());
        return "/signup";
    }

    @PostMapping("/register")
    public RedirectView register(UserDTO userDTO, RedirectAttributes redirectAttributes){
        String prefix = userDTO.getEmailPrefix();
        String dns = userDTO.getEmailDns();
        String email = prefix + "@" + dns;
        userDTO.setUserEmail(email);
        userService.write(userDTO);
        System.out.println(userDTO);
        redirectAttributes.addFlashAttribute("uId", userDTO.getUserId());
//        추가후 새로고침을해도 redirect로 인해 list로 가더라도 계속 추가되지않는다.
        return new RedirectView("/login");
    }

    @PostMapping("/modify")
    public RedirectView modify(Principal principal, RedirectAttributes redirectAttributes, UserDTO userDTO){
        PrincipalDetails principalDetails = (PrincipalDetails)principal;
        String prefix = userDTO.getEmailPrefix();
        String dns = userDTO.getEmailDns();
        String email = prefix + "@" + dns;
        userService.modify(userDTO);
        principalDetails.setDto(userDTO);
        redirectAttributes.addAttribute("userId", userDTO.getUserId());
        return new RedirectView("/5-1myInfo");
    }

    @GetMapping("/remove")
    public RedirectView remove(Principal principal){
        String userId = principal.getName();
        userService.delete(userId);
        return new RedirectView("/main");
    }

    //    로그인 창으로 이동
    @GetMapping("/login")
    public void loginForm(){
    }

}

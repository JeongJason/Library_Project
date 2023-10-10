package com.example.app.controller;

import com.example.app.auth.PrincipalDetails;
import com.example.app.domain.dto.BookDTO;
import com.example.app.domain.dto.UserDTO;
import com.example.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user/*")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/all")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping(value={"read","modify"})
    public UserDTO getUser(Principal principal){
        return userService.getUser(principal.getName());
    }

//    회원가입 창으로 이동
    @GetMapping("/register.do")
    public String registerForm(){
       return "/register";
    }

    @PostMapping("/register")
    public RedirectView register(UserDTO userDTO, RedirectAttributes redirectAttributes){
        userService.write(userDTO);
        redirectAttributes.addFlashAttribute("uId", userDTO.getUserId());
//        추가후 새로고침을해도 redirect로 인해 list로 가더라도 계속 추가되지않는다.
        return new RedirectView("/user/registerSuccess");
    }

    @PostMapping("/modify")
    public RedirectView modify(Principal principal,RedirectAttributes redirectAttributes, UserDTO userDTO){
        PrincipalDetails principalDetails = (PrincipalDetails)principal;
        principalDetails.setUserDTO(userDTO);
        userService.modify(userDTO);
        redirectAttributes.addAttribute("userId", userDTO.getUserId());
        return new RedirectView("/user/read");
    }

    @GetMapping("/remove")
    public RedirectView remove(Principal principal){
        String userId = principal.getName();
        userService.delete(userId);
        return new RedirectView("/main");
    }

//    로그인 창으로 이동
    @GetMapping("/login.do")
    public String loginForm(){
        return "/login";
    }

}

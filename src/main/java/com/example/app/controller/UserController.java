package com.example.app.controller;

import com.example.app.auth.PrincipalDetails;
import com.example.app.domain.dto.BookDTO;
import com.example.app.domain.dto.UserDTO;
import com.example.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
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

    @GetMapping(value={"read","modify"})
    public UserDTO getUser(Principal principal){
        return userService.getUser(principal.getName());
    }



//    @PostMapping("/register")
//    public String register(@RequestParam String emailPrefix, @RequestParam String emailDns, UserDTO userDTO) {
//
//        // Combine the two parts and set the userEmail field
//        userDTO.setUserEmail(emailPrefix + '@' + emailDns);
//
//        userService.write(userDTO);
//
//        return "/login";
//    }
    //    회원가입 창으로 이동
    @GetMapping("/register")
    public String registerForm(@ModelAttribute("userDTO") UserDTO userDTO){

        return "/signup";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("userDTO") UserDTO userDTO, RedirectAttributes redirectAttributes) {
        String Prefix = userDTO.getEmailPrefix();
        String DNS = userDTO.getEmailDns();
        String email = Prefix + "@" + DNS;
        System.out.println(email);

        userDTO.setUserEmail(email);
        userService.write(userDTO);
        redirectAttributes.addFlashAttribute("userId", userDTO.getUserId());

        return "/login";
    }

    @PostMapping("/modify")
    public RedirectView modify(Principal principal,RedirectAttributes redirectAttributes, UserDTO userDTO){
        PrincipalDetails principalDetails = (PrincipalDetails)principal;
        principalDetails.setDto(userDTO);
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
    @GetMapping("/login")
    public void loginForm(){
    }



}

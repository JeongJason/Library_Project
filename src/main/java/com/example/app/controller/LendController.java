package com.example.app.controller;

import com.example.app.domain.dto.BookDTO;
import com.example.app.domain.dto.LendDTO;
import com.example.app.domain.dto.UserDTO;
import com.example.app.service.BookService;
import com.example.app.service.LendService;
import com.example.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class LendController {
    private final LendService lendService;
    private final BookService bookService;



    @PostMapping("/books/lend")
    public String postLend(LendDTO lendDTO, RedirectAttributes redirectAttributes,Principal principal){
        String username = principal.getName();
        lendDTO.setUserId(username);
        lendService.write(lendDTO);
    //        redirectAttributes.addFlashAttribute("message", "Book has been successfully lent.");
        return "redirect:/books/1-1search";
    }

}

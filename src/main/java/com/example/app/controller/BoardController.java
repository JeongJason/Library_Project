package com.example.app.controller;

import com.example.app.service.BoardService;
<<<<<<< HEAD
import lombok.AllArgsConstructor;
=======
>>>>>>> 3bae0715b6a27d24af23880291f089f47c145460
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/boards/*")
public class BoardController {
    private final BoardService boardService;
}

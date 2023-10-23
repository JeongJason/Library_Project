package com.example.app.controller;

import com.example.app.service.LendService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class LendController {
    private final LendService lendService;

}

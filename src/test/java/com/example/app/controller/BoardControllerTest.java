package com.example.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@Slf4j
public class BoardControllerTest {

    @Autowired
    BoardController boardController;
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc  mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void showListTest() throws Exception {
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/boards/notice")
                .param("pagenum", "2")
                .param("type","tw")
                .param("keyword","안녕")
        ).andReturn().getModelAndView().getModelMap().toString());
    }

}

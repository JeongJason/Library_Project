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
public class UserControllerTest {

    @Autowired
    private UserController userController;
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void insertTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .param("userId", "admin4")
                .param("userPw", "1234")
                .param("userName", "admin")
                .param("userEmail", "admin@example.com")
                .param("emailPrefix", "admin")
                .param("emailDns","text.com")
                .param("userBirth", "1991.09.05")
                .param("userRole", "ROLE_ADMIN")
        ).andReturn().getFlashMap().toString());
    }

}

package com.example.app.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class UserDTO {
    private String uId;
    private String uPw;
    private String uName;
    private String uEmail;
    private String uBirth;
    private String uRole; // admin or user

}

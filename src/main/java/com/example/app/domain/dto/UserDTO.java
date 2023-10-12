package com.example.app.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class UserDTO {
    private String userId;
    private String userPw;
    private String userName;
    private String userEmail;
    private String userBirth;
    private String userRole; // admin or user
    private String userRegisterDate;

}

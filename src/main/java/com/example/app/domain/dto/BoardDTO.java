package com.example.app.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BoardDTO {
    private int anId;
    private String anTitle;
    private String userId;
    private String anContent;
    private String anRegisterDate;
    private String anUpdateDate;
}

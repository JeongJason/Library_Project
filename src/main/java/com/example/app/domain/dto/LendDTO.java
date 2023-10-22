package com.example.app.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LendDTO {
    private Long lendSeq;
    private String isbn;
    private String userId;
    private String lendDate;
    private String dueDate;
    private String extensionCnt;
    private String lendReturnYN;
    private String lateDays;

    private String bookTitle;
    private String Author;
    private String publisher;
    private int pubYear;
}

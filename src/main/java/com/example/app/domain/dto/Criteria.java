package com.example.app.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Criteria {
    private int page;
    private int rowCount; // 총 몇개의 페이지를 보여줄건지 정하는 변수
    private int pageCount; // 한 페이지에 총 몇개의 개시물을 보여줄건지 정하는 변수
    private int startPage;
    private int endPage;
    private int realEnd;
    private boolean prev, next;
    private int total;

    public void create(int total){
        this.total = total;
        this.rowCount = 10;
        this.pageCount = 10;
        this.endPage = (int)Math.ceil(page / (double)pageCount) * pageCount;
        this.startPage = endPage - pageCount + 1;
        this.realEnd = (int)Math.ceil(total / (double)rowCount);

        if(realEnd < endPage){
            endPage = realEnd == 0 ? 1 : realEnd;
//            만약 게시글이 1개도 없을경우 end page가 0이되는 버그가 생길수있다. 따라서 realEnd가 0일경우 1을 넣어줘야한다.
        }

        this.prev = startPage>1;
        this.next = endPage < realEnd;

    }

}

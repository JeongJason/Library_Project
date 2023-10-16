package com.example.app.service;

import com.example.app.domain.dto.BoardDTO;
import com.example.app.domain.dto.ReviewDTO;
import com.example.app.domain.dto.Search;
import com.example.app.domain.paging.Criteria;
import com.example.app.mapper.BoardMapper;
import com.example.app.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewMapper reviewMapper;

    // 리뷰 조회
    public ReviewDTO getBoard(Long revId){
        return reviewMapper.select(revId);
    }
    // 리뷰 목록
    public List<ReviewDTO> getList(Criteria criteria, Search search){
        return reviewMapper.selectAll(criteria, search);
    }
    // 리뷰 추가
    public void write(ReviewDTO reviewDTO){
        reviewMapper.insert(reviewDTO);
    }
    // 리뷰 삭제
    public void delete(Long revId){
        reviewMapper.delete(revId);
    }
    // 리뷰 수정
    public void modify(ReviewDTO reviewDTO){
        reviewMapper.update(reviewDTO);
    }

    // 리뷰 전체 개수 조회
    public Long getTotal(Search search){
        return reviewMapper.selectCountAll(search);
    }
}

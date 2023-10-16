package com.example.app.mapper;

import com.example.app.domain.dto.WishDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WishMapper {
    // 신청 도서 정보 추가
    public void insert(WishDTO wishDTO);

}

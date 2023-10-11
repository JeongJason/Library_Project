package com.example.app.mapper;

import com.example.app.domain.dto.BoardDTO;
import com.example.app.domain.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 게시글 조회
    public BoardDTO select(int anId);
    // 게시글 목록
    public List<BoardDTO> selectAll(Criteria criteria);
    // 게시글 추가
    public void insert(BoardDTO boardDTO);
    // 게시글 삭제
    public void delete(int anId);
    // 게시글 수정
    public void update(BoardDTO boardDTO);
    // 전체 게시글 갯수
    public Long selectCountAll();


}

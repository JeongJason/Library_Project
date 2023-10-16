package com.example.app.service;

import com.example.app.domain.dto.BoardDTO;
import com.example.app.domain.dto.Search;
import com.example.app.domain.paging.Criteria;
import com.example.app.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardmapper;

    // 게시글 조회
    public BoardDTO getBoard(Long anId){
        return boardmapper.select(anId);
    }
    // 게시글 목록
    public List<BoardDTO> getList(Criteria criteria, Search search){
        return boardmapper.selectAll(criteria, search);
    }
    // 게시글 추가
    public void write(BoardDTO boardDTO){
        boardmapper.insert(boardDTO);
    }
    // 게시글 삭제
    public void delete(Long anId){
        boardmapper.delete(anId);
    }
    // 게시글 수정
    public void modify(BoardDTO boardDTO){
        boardmapper.update(boardDTO);
    }

    //    게시글 전체 개수 조회
    public Long getTotal(Search search){
        return boardmapper.selectCountAll(search);
    }
}

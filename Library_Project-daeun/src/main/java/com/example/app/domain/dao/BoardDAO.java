package com.example.app.domain.dao;

import com.example.app.domain.dto.BoardDTO;
import com.example.app.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
    private final BoardMapper boardMapper;

    // 게시글 조회
    public BoardDTO findbyId(int anId){
        return boardMapper.select(anId);
    }
    // 게시글 목록
    public List<BoardDTO> findAll(){
        return boardMapper.selectAll();
    }
    // 게시글 추가
    public void save(BoardDTO boardDTO){
        boardMapper.insert(boardDTO);
    }
    // 게시글 삭제
    public void delete(int anId){
        boardMapper.delete(anId);
    }
    // 게시글 수정
    public void setBoard(BoardDTO boardDTO){
        boardMapper.update(boardDTO);
    }

}

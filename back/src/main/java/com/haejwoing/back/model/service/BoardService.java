package com.haejwoing.back.model.service;

import com.haejwoing.back.model.dto.Board;
import com.haejwoing.back.model.mapper.BoardMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService implements BoardImpl{

    @Autowired
    private SqlSession sqlSession;


    @Override
    public List<Board> getList() {
        return sqlSession.getMapper(BoardMapper.class).getList();
    }

    @Override
    public Board get(int boardSeq) {
        return null;
    }

    @Override
    public void save(Board board) {
        sqlSession.getMapper(BoardMapper.class).save(board);
    }

    @Override
    public void update(Board board) {

    }

    @Override
    public void delete(int boardSeq) {

    }
}

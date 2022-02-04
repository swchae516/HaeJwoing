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
    public Board get(int idboard) {
        return sqlSession.getMapper(BoardMapper.class).get(idboard);
    }

    @Override
    public boolean save(Board board) throws Exception{
        if(board.getContent() == null){
            throw new Exception();
        }
        return sqlSession.getMapper(BoardMapper.class).save(board)==1;
    }

    @Override
    public void update(int boardSeq) {
        sqlSession.getMapper(BoardMapper.class).update(boardSeq);
    }

    @Override
    public void delete(int boardSeq) {
        sqlSession.getMapper(BoardMapper.class).delete(boardSeq);
    }
}

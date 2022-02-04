package com.haejwoing.back.model.service;

import com.haejwoing.back.model.dto.Comment;
import com.haejwoing.back.model.mapper.CommentMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements CommentServiceImpl{

    @Autowired
    private SqlSession sqlSession;


    @Override
    public List<Comment> getList() {
        return sqlSession.getMapper(CommentMapper.class).getList();
    }

    @Override
    public Comment get(int commentId) {
        return null;
    }

    @Override
    public void save(Comment comment) {
        sqlSession.getMapper(CommentMapper.class).save(comment);
    }

    @Override
    public void update(Comment comment) {

    }

    @Override
    public void delete(int commentId) {

    }
}

package com.haejwoing.back.model.service;

import com.haejwoing.back.model.dto.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getList();

    Comment get(int commentId);

    void save(Comment comment);

    void update(Comment comment);

    void delete(int commentId);

}
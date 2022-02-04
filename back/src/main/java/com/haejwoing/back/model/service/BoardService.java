package com.haejwoing.back.model.service;

import com.haejwoing.back.model.dto.Board;

import java.util.List;

public interface BoardService {

    List<Board> getList();

    Board get(int boardSeq);

    boolean save(Board board) throws Exception;

    void update(int boardSeq);

    void delete(int boardSeq);

}
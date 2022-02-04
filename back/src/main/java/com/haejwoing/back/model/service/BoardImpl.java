package com.haejwoing.back.model.service;

import com.haejwoing.back.model.dto.Board;

import java.util.List;

public interface BoardImpl {

    List<Board> getList();

    Board get(int boardSeq);

    void save(Board board);

    void update(Board board);

    void delete(int boardSeq);

}

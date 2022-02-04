package com.haejwoing.back.model.mapper;

import com.haejwoing.back.model.dto.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> getList();

    Board get(int boardSeq);

    int save(Board board);

    void update(int boardSeq);

    void delete(int boardSeq);

}

package com.haejwoing.back.model.mapper;


import com.haejwoing.back.model.dto.Board;
import com.haejwoing.back.model.dto.HashTag;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface HashTagMapper {


    boolean save(Board board);

    int recent_id(int boardid);

}

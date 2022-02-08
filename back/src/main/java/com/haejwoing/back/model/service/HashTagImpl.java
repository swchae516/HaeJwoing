package com.haejwoing.back.model.service;


import com.haejwoing.back.model.dto.Board;
import com.haejwoing.back.model.dto.HashTag;
import com.haejwoing.back.model.mapper.HashTagMapper;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.apache.ibatis.session.SqlSession;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springfox.documentation.spring.web.json.Json;
import org.json.simple.parser.JSONParser;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HashTagImpl implements HashTagService{

    @Autowired
    private SqlSession sqlSession;


    @Override
    public boolean save(Board board) {

        String text = board.getHashArr().substring(1,board.getHashArr().length()-1);

        String[] abc = text.split(",");

        List<String> cde = new ArrayList<>();

        for (int i=0; i<abc.length; i++){
            cde.add(abc[i]);
        }

        board.setHasArrList(cde);
        System.out.println(board);


        int recent_id = sqlSession.getMapper(HashTagMapper.class).recent_id(board.getRecent_id());
        System.out.println(recent_id);
        board.setRecent_id(recent_id);

        return sqlSession.getMapper(HashTagMapper.class).save(board);
    }

}

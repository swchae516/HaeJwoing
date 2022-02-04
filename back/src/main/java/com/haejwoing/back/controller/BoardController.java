package com.haejwoing.back.controller;


import com.haejwoing.back.model.dto.Board;
import com.haejwoing.back.model.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("")
    public List<Board> getList(){
        return boardService.getList();
    }

    @GetMapping("/{boardSeq}")
    public Board get(@PathVariable int boardSeq){
        return boardService.get(boardSeq);

    }

    @GetMapping("/save")
    public void save(Board board){
        boardService.save(board);
    }

    @GetMapping("/delete/{boardSeq}")
    public void delete(@PathVariable int boardSeq){
        boardService.delete(boardSeq);
    }



}

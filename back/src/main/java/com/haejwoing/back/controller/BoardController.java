package com.haejwoing.back.controller;


import com.haejwoing.back.model.dto.Board;
import com.haejwoing.back.model.service.BoardService;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("")
    public ResponseEntity<List<Board>> BoardList(Board board){
        return new ResponseEntity<List<Board>>(boardService.getList(), HttpStatus.OK);
    }


    @GetMapping("/{idboard}")
    public ResponseEntity<Board> BoardList(@PathVariable int idboard){
        return new ResponseEntity<Board>(boardService.get(idboard), HttpStatus.OK);
    }


    @PostMapping("/save")
   public ResponseEntity<String> save(@RequestBody Board board) throws Exception {
        if(boardService.save(board)){
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{boardSeq}")
    public void update(@PathVariable int boardSeq){
        boardService.update(boardSeq);
    }


    @DeleteMapping("/delete/{boardSeq}")
    public void delete(@PathVariable int boardSeq){
        boardService.delete(boardSeq);
    }



}

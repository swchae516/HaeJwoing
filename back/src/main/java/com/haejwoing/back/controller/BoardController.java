package com.haejwoing.back.controller;


import com.haejwoing.back.model.dto.Board;
import com.haejwoing.back.model.dto.VoteUsersExport;
import com.haejwoing.back.model.dto.VoteUsersImport;
import com.haejwoing.back.model.service.BoardService;
import com.haejwoing.back.model.service.HashTagService;
import com.haejwoing.back.model.service.VoteUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private HashTagService hashTagService;

    @Autowired
    private VoteUsersService voteUsersService;

    @GetMapping("")
    public ResponseEntity<List<Board>> BoardList(Board board){

        return new ResponseEntity<List<Board>>(boardService.getList(), HttpStatus.OK);
    }


    @GetMapping("/{idboard}")
    public ResponseEntity<Board> BoardList(@PathVariable int idboard){
        return new ResponseEntity<Board>(boardService.get(idboard), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Board>> getUser(@PathVariable int userId){
        return new ResponseEntity<List<Board>>(boardService.getUser(userId), HttpStatus.OK);
    }


    @GetMapping("/hashtagsearch")
    public ResponseEntity<List<Board>> HashTagList(@RequestBody Map<String, String> import_tag_name){

        return new ResponseEntity<List<Board>>(hashTagService.getList_hashtag(import_tag_name.get("tag_name")), HttpStatus.OK);
    }


    @PostMapping("/savevoteusers")
    public ResponseEntity<String> VoteUsersList(@RequestBody VoteUsersImport voteUsersImport){

        voteUsersService.save_vote_users(voteUsersImport);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @PostMapping("/getvoteusers")
    public ResponseEntity<VoteUsersExport> GetVoteUsersList(@RequestBody VoteUsersExport voteUsersExport){

        return new ResponseEntity<VoteUsersExport>(voteUsersService.get_vote_users(voteUsersExport), HttpStatus.OK);
    }



    @PostMapping("/save")
   public ResponseEntity<String> save(@RequestBody Board board) throws Exception {

        if(boardService.save(board)){

            if(hashTagService.save(board)) {

                return new ResponseEntity<String>(HttpStatus.OK);
            }
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")

    public ResponseEntity<String> update(@RequestBody Board board){
        System.out.println(board);
        if(boardService.update(board)){
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping("/delete/{idboard}")
    public ResponseEntity<String> delete(@PathVariable int idboard){
        if(boardService.delete(idboard)){
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }



}

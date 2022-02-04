package com.haejwoing.back.controller;

import com.haejwoing.back.model.dto.Comment;
import com.haejwoing.back.model.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/board/{idBoard}/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

//    @GetMapping("")
//    public List<Comment> getList() {
//        return CommentService.getList();
//    }

    @GetMapping("/{idComment}")
    public Comment get(@PathVariable int idComment) {
        return commentService.get(idComment);
    }

    @PostMapping("/save")
    public void save(Comment comment) {
        commentService.save(comment);
    }

//    @PutMapping("/{idComment}/update")
//    public void update()

}

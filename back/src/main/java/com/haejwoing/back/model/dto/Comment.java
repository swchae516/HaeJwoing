package com.haejwoing.back.model.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Comment {
    private int idComment;
    private String content;
    private Timestamp created_at;
    private Timestamp updated_at;
    private int type; // 1, 2, 3
    private int user_id;
    private int vote_idvote;
}

package com.haejwoing.back.model.dto;


import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

@Data
public class Board {

    private int idboard;
    private String title;
    private String view_range;
    private String content;
    private String board_image;
    private int type;
    private int vote_idvote;

}

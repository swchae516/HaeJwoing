package com.haejwoing.back.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class VoteUsersExport {

    private int board_idboard;
    private List<Integer> user_id;
    private List<Integer> idx;
//    private int user_id;
//    private int idx;
}

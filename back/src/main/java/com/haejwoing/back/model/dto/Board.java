package com.haejwoing.back.model.dto;


import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import springfox.documentation.spring.web.json.Json;

import javax.swing.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class Board {

    private int idboard;
    private String view_range;
    private String content;
    private String board_image;
    private int type;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime due_date;
    private String vote_contents;

}

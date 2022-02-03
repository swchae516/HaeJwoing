package com.haejwoing.back.controller;

import com.haejwoing.back.model.dto.User;
import com.haejwoing.back.model.service.UserService;
import com.haejwoing.back.model.service.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "회원정보")
    @GetMapping("/{nickname}")
    public ResponseEntity<Map<String, Object>> userInfo(@PathVariable @ApiParam(value = "유저 정보") String nickname){
        log.info("회원정보 ");
        log.info("{}",nickname);
        HttpStatus status = HttpStatus.ACCEPTED;

        Map<String, Object> result = new HashMap<>();
        User user = userService.searchByUsername(nickname);
        System.out.println(user);
        result.put("info", user);

        return new ResponseEntity<Map<String, Object>>(result, status);
    }
}

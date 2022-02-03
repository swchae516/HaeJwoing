package com.haejwoing.back.model.mapper;

import com.haejwoing.back.model.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void insertUser(User user);
    User searchByUserName(String userName);
}

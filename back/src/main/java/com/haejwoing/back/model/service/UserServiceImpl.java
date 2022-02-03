package com.haejwoing.back.model.service;

import com.haejwoing.back.model.dto.User;
import com.haejwoing.back.model.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserServiceImpl {
    void insertUser(User user);
    List<User> listUser();
    User searchByUsername(String userName);
}

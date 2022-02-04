package com.haejwoing.back.model.service;

import com.haejwoing.back.model.dto.User;

import java.util.List;

public interface UserService {
    void insertUser(User user);
    List<User> listUser();
    User searchByUsername(String userName);
}

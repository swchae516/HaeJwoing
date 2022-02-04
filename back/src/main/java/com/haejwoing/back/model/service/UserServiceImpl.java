package com.haejwoing.back.model.service;

import com.haejwoing.back.model.dto.User;
import com.haejwoing.back.model.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private SqlSession sqlSession;


    @Override
    public void insertUser(User user) {
        sqlSession.getMapper(UserMapper.class).insertUser(user);
    }

    @Override
    public List<User> listUser() {
        return null;
    }

    @Override
    public User searchByUsername(String userName) {
        return sqlSession.getMapper(UserMapper.class).searchByUserName(userName);
    }
}

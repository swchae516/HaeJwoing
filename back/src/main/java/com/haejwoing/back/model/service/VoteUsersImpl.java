package com.haejwoing.back.model.service;

import com.haejwoing.back.model.dto.VoteUsersExport;
import com.haejwoing.back.model.dto.VoteUsersImport;
import com.haejwoing.back.model.mapper.VoteUsersMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteUsersImpl implements VoteUsersService{

    @Autowired
    SqlSession sqlSession;


    @Override
    public void save_vote_users(VoteUsersImport voteUsersImport) {
        System.out.println(voteUsersImport);
        sqlSession.getMapper(VoteUsersMapper.class).save_vote_users(voteUsersImport);
    }

    @Override
    public VoteUsersExport get_vote_users(VoteUsersExport voteUsersExport) {
        System.out.println(voteUsersExport);
        return sqlSession.getMapper(VoteUsersMapper.class).get_vote_users(voteUsersExport);
    }
}

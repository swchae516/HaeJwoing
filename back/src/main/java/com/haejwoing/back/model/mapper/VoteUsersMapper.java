package com.haejwoing.back.model.mapper;

import com.haejwoing.back.model.dto.VoteUsersExport;
import com.haejwoing.back.model.dto.VoteUsersImport;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VoteUsersMapper {

    void save_vote_users(VoteUsersImport voteUsersImport);

    VoteUsersExport get_vote_users(VoteUsersExport voteUsersExport);


}

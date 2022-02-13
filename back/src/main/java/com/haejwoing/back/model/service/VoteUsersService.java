package com.haejwoing.back.model.service;

import com.haejwoing.back.model.dto.VoteUsersImport;
import com.haejwoing.back.model.dto.VoteUsersExport;
import org.springframework.stereotype.Service;


public interface VoteUsersService {

    void save_vote_users(VoteUsersImport voteUsersImport);

    VoteUsersExport get_vote_users(VoteUsersExport voteUsersExport);
}

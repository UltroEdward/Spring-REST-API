package com.test.voating.service;

import java.util.List;

import com.test.voating.exceptions.VoteBasicException;
import com.test.voating.models.entity.VoteRoom;

public interface VoteRoomService {

    public VoteRoom findById(int id) throws VoteBasicException;

    public VoteRoom addVoteRoom(VoteRoom room) throws VoteBasicException;

    public VoteRoom updateVoteRoom(VoteRoom room) throws VoteBasicException;

    public List<VoteRoom> findAll();

    public VoteRoom setStatus(int id, boolean b) throws VoteBasicException;

}

package com.test.voating.service;

import java.util.List;

import com.test.voating.model.VoteRoom;

public interface VoteRoomService {

	public VoteRoom findById(int id);

	public VoteRoom addVoteRoom(VoteRoom room);

	public VoteRoom updateVoteRoom(VoteRoom room);

	public List<VoteRoom> findAll();

}

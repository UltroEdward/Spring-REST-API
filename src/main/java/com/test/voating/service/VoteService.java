package com.test.voating.service;

import java.util.List;

import com.test.voating.model.VoteRoom;

public interface VoteService {

	public VoteRoom findRoomById(int id);

	public void saveVoteRoom(VoteRoom room);

	public void updateVoteRoom(VoteRoom room);
	
	public List<VoteRoom> getVoteRooms();

}

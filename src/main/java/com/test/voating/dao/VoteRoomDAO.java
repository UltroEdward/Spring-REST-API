package com.test.voating.dao;

import java.util.List;

import com.test.voating.model.VoteRoom;

public interface VoteRoomDAO {

	public VoteRoom findRoomById(int id);

	void saveVoteRoom(VoteRoom room);

	void updateVoteRoom(VoteRoom room);
	
	public List<VoteRoom> getVoteRooms();
}

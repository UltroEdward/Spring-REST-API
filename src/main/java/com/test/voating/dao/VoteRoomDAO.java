package com.test.voating.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.test.voating.model.VoteRoom;

public interface VoteRoomDAO extends Repository<VoteRoom,Integer> {

	public VoteRoom findById(int id);

	//void saveVoteRoom(VoteRoom room);

	//void updateVoteRoom(VoteRoom room);
	
	public List<VoteRoom> findAll();
}

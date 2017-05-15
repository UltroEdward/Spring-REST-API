package com.test.voating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.voating.dao.VoteRoomDAO;
import com.test.voating.model.VoteRoom;

@Component
public class VoteRoomServiceImpl implements VoteRoomService {

	@Autowired
	private VoteRoomDAO voteRoomDao;

	public VoteRoom findById(int id) {
		return voteRoomDao.findById(id);
	}

	public VoteRoom addVoteRoom(VoteRoom room) {
		VoteRoom roomSaved = voteRoomDao.saveAndFlush(room);
		return roomSaved;
	}

	public VoteRoom updateVoteRoom(VoteRoom room) {
		VoteRoom roomSaved = voteRoomDao.saveAndFlush(room);
		return roomSaved;
	}

	public List<VoteRoom> findAll() {
		return voteRoomDao.findAll();
	}
}

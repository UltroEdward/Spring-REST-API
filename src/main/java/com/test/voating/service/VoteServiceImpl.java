package com.test.voating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.voating.dao.VoteRoomDAOImpl;
import com.test.voating.model.VoteRoom;

@Component
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteRoomDAOImpl voteDao;

	public VoteRoom findRoomById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveVoteRoom(VoteRoom room) {
		// TODO Auto-generated method stub

	}

	public void updateVoteRoom(VoteRoom room) {
		// TODO Auto-generated method stub

	}

	public List<VoteRoom> getVoteRooms() {
		return voteDao.getVoteRooms();
	}
}

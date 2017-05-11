package com.test.voating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.voating.dao.VoteRoomDAO;
import com.test.voating.model.VoteRoom;

@Component
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteRoomDAO voteDao;

	public VoteRoom findById(int id) {
		return voteDao.findById(id);
	}

	public void saveVoteRoom(VoteRoom room) {
		// TODO Auto-generated method stub

	}

	public void updateVoteRoom(VoteRoom room) {
		// TODO Auto-generated method stub

	}

	public List<VoteRoom> findAll() {
		return voteDao.findAll();
	}
}

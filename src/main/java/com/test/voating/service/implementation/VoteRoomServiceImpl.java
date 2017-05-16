package com.test.voating.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.voating.dao.QuestionDAO;
import com.test.voating.dao.VoteRoomDAO;
import com.test.voating.entity.VoteRoom;
import com.test.voating.service.VoteRoomService;

@Component
public class VoteRoomServiceImpl implements VoteRoomService {

	@Autowired
	private VoteRoomDAO voteRoomDao;
	@Autowired
	private QuestionDAO questionDao;

	public VoteRoom findById(int id) {
		return voteRoomDao.findOne(id);
	}

	public VoteRoom addVoteRoom(VoteRoom room) {
		room.setId(0); // let db generate id
		if (questionDao.findOne(room.getIdQuestion()) == null) {
			return null;
		}
		
		room = validateVoteRoom(room);
		if (room == null) {
			return null;
		}
		
		VoteRoom roomSaved = voteRoomDao.saveAndFlush(room);
		return roomSaved;
	}

	public VoteRoom updateVoteRoom(VoteRoom room) {
		VoteRoom existingRoom = voteRoomDao.findOne(room.getId());
		if (existingRoom == null) {
			return null;
		}

		room = validateVoteRoom(room);
		if (room == null) {
			return null;
		}
		
		VoteRoom roomSaved = voteRoomDao.saveAndFlush(room);
		return roomSaved;
	}

	public List<VoteRoom> findAll() {
		return voteRoomDao.findAll();
	}

	private VoteRoom validateVoteRoom(VoteRoom room) {
		
		if (questionDao.findOne(room.getIdQuestion()) == null) {
			return null;
		}

		if (room.getName() == null || room.getName().isEmpty()) {
			return null;
		}
		return room;
	}
}

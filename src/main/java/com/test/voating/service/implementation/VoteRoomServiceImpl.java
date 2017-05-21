package com.test.voating.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.voating.dao.VoteRoomDAO;
import com.test.voating.exceptions.VoteBasicException;
import com.test.voating.exceptions.VoteIllegalStateException;
import com.test.voating.exceptions.VoteItemCreationException;
import com.test.voating.exceptions.VoteItemNotFoundException;
import com.test.voating.models.entity.VoteRoom;
import com.test.voating.service.QuestionService;
import com.test.voating.service.VoteRoomService;

@Service
public class VoteRoomServiceImpl implements VoteRoomService {

    @Autowired
    private VoteRoomDAO voteRoomDao;
    @Autowired
    private QuestionService questionService;

    public VoteRoom findById(int id) throws VoteItemNotFoundException {
	VoteRoom voteRoom = voteRoomDao.findOne(id);
	try {
	    voteRoom.getId();
	} catch (Exception ex) {
	    throw new VoteItemNotFoundException("Room id is incorrect or not exist");
	}
	return voteRoom;
    }

    public VoteRoom addVoteRoom(VoteRoom roomToSave) throws VoteIllegalStateException, VoteItemCreationException, VoteItemNotFoundException {
	roomToSave.setId(0); // let db generate id
	roomToSave = validateVoteRoom(roomToSave);
	roomToSave.setOpened(false); // closed by default

	VoteRoom room = null;
	try {
	    room = voteRoomDao.saveAndFlush(roomToSave);
	} catch (Exception ex) {
	    throw new VoteItemCreationException("Can't add Room: " + ex.getMessage());
	}

	return room;
    }

    public VoteRoom updateVoteRoom(VoteRoom roomToSave) throws VoteIllegalStateException, VoteItemCreationException, VoteItemNotFoundException {
	VoteRoom existingRoom = voteRoomDao.findOne(roomToSave.getId());
	if (existingRoom == null) {
	    throw new VoteIllegalStateException("Room can't be updated, as it not presented");
	}

	roomToSave = validateVoteRoom(roomToSave);
	try {
	    existingRoom = voteRoomDao.saveAndFlush(roomToSave);
	} catch (Exception ex) {
	    throw new VoteItemCreationException("Can't add Room: " + ex.getMessage());
	}

	return existingRoom;
    }

    public List<VoteRoom> findAll() {
	return voteRoomDao.findAll();
    }

    public VoteRoom setStatus(int id, boolean isOpened) throws VoteBasicException {

	VoteRoom roomFromDb = findById(id);
	roomFromDb.setOpened(isOpened);
	VoteRoom room = updateVoteRoom(roomFromDb);
	return room;

    }

    private VoteRoom validateVoteRoom(VoteRoom room) throws VoteIllegalStateException, VoteItemNotFoundException {

	if (room.getName() == null || room.getName().isEmpty()) {
	    throw new VoteIllegalStateException("Room name is not presented, can't add");
	}

	if (questionService.findById(room.getIdQuestion()) == null) {
	    throw new VoteIllegalStateException("Question id is not presented, can't add");
	}

	return room;
    }

}

package com.test.voating.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.voating.dao.VoteDAO;
import com.test.voating.exceptions.VoteIllegalStateException;
import com.test.voating.exceptions.VoteItemNotFoundException;
import com.test.voating.models.entity.Vote;
import com.test.voating.service.AnswerService;
import com.test.voating.service.VoteRoomService;
import com.test.voating.service.VotingService;

@Component
public class VotingServiceImpl implements VotingService {

    @Autowired
    private VoteDAO voteDao;
    @Autowired
    private VoteRoomService voteRoomService;
    @Autowired
    private AnswerService answerService;

    @Override
    public List<Vote> findAll() {
	return voteDao.findAll();
    }

    @Override
    public Vote findById(int id) throws VoteItemNotFoundException {
	Vote vote = voteDao.findOne(id);
	try {
	    vote.getId();
	} catch (Exception ex) {
	    throw new VoteItemNotFoundException("Vote id is incorrect or not exist");
	}
	return vote;
    }

    @Override
    public List<Vote> findByAnswerAndRoomId(int id, int roomId) throws VoteItemNotFoundException {
	answerService.findById(id);
	return voteDao.findByAnswerIdAndRoom(id, roomId);
    }

    @Override
    public Vote makeVote(Vote vote) throws VoteIllegalStateException, VoteItemNotFoundException {
	vote.setId(0); // let db generate id
	if (vote.getRoomId() == 0 || voteRoomService.findById(vote.getRoomId()) == null) {
	    throw new VoteIllegalStateException("Room id is not presented, can't add");
	}
	if (vote.getAnswerId() == 0 || answerService.findById(vote.getAnswerId()) == null) {
	    throw new VoteIllegalStateException("Answer id is not presented, can't add");
	}
	if (!voteRoomService.findById(vote.getRoomId()).isOpened()) {
	    throw new VoteIllegalStateException("Room is closed, voting is not possible");
	}
	if (answerService.findById(vote.getAnswerId()).getQuestionId() != voteRoomService.findById(vote.getRoomId()).getIdQuestion()) {
	    throw new VoteIllegalStateException("This answer is not connected with room's question");
	}

	Vote v = voteDao.saveAndFlush(vote);
	return v;
    }

    @Override
    public Vote addVoteByRoom(int roomId, int answerId) throws VoteIllegalStateException, VoteItemNotFoundException {
	Vote vote = new Vote();
	vote.setAnswerId(answerId);
	vote.setRoomId(roomId);
	return makeVote(vote);
    }

}

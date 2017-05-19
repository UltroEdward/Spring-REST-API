package com.test.voating.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.voating.dao.AnswerDAO;
import com.test.voating.dao.VoteDAO;
import com.test.voating.dao.VoteRoomDAO;
import com.test.voating.models.entity.Vote;
import com.test.voating.service.VotingService;

@Component
public class VotingServiceImpl implements VotingService {

	@Autowired
	private VoteDAO voteDao;
	@Autowired
	private VoteRoomDAO voteRoomDao;
	@Autowired
	private AnswerDAO answerDAO;

	@Override
	public Vote makeVote(Vote vote) {
		vote.setId(0); // let db generate id
		if (vote.getRoomId() == 0 || voteRoomDao.getOne(vote.getRoomId()) == null) {
			return null;
		}
		if (vote.getAnswerId() == 0 || answerDAO.getOne(vote.getAnswerId()) == null) {
			return null;
		}
		Vote v = voteDao.saveAndFlush(vote);
		return v;
	}

	@Override
	public List<Vote> findAll() {
		return voteDao.findAll();
	}

	@Override
	public Vote findById(int id) {
		return voteDao.findOne(id);
	}

	@Override
	public List<Vote> findByAnswerId(int id) {
		return voteDao.findByAnswerId(id);
	}
	
}

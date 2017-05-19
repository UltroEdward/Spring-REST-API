package com.test.voating.service;

import java.util.List;

import com.test.voating.models.entity.Vote;

public interface VotingService {

	public Vote makeVote(Vote vote);
	
	public List<Vote> findAll();
	
	public Vote findById(int id);
	
	public List<Vote> findByAnswerId(int id);
}

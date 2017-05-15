package com.test.voating.service;

import com.test.voating.model.Vote;
import com.test.voating.model.VoteRoom;

public interface VotingService {

	public VoteRoom makeVote(Vote vote);
}

package com.test.voating.service;

import com.test.voating.entity.Vote;
import com.test.voating.entity.VoteRoom;

public interface VotingService {

	public VoteRoom makeVote(Vote vote);
}

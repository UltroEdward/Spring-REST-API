package com.test.voating.service;

import java.util.List;

import com.test.voating.exceptions.VoteIllegalStateException;
import com.test.voating.exceptions.VoteItemNotFoundException;
import com.test.voating.models.entity.Vote;

public interface VotingService {

    public Vote makeVote(Vote vote) throws VoteIllegalStateException, VoteItemNotFoundException;

    public List<Vote> findAll();

    public Vote findById(int id) throws VoteItemNotFoundException;

    public Vote addVoteByRoom(int roomId, int answerId) throws VoteIllegalStateException, VoteItemNotFoundException;

    public List<Vote> findByAnswerAndRoomId(int answerId, int roomId) throws VoteItemNotFoundException;
}

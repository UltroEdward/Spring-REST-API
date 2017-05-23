package com.test.voating.service;

import java.util.List;

import com.test.voating.exceptions.VoteBasicException;
import com.test.voating.models.entity.Vote;

public interface VotingService {

    public Vote makeVote(Vote vote) throws VoteBasicException;

    public List<Vote> findAll();

    public Vote findById(int id) throws VoteBasicException;

    public Vote addVoteByRoom(int roomId, int answerId) throws VoteBasicException;

    public List<Vote> findByAnswerAndRoomId(int answerId, int roomId) throws VoteBasicException;
}

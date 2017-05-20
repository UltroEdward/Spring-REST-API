package com.test.voating.service;

import java.util.List;

import com.test.voating.exceptions.VoteBasicException;
import com.test.voating.exceptions.VoteIllegalStateException;
import com.test.voating.exceptions.VoteItemCreationException;
import com.test.voating.exceptions.VoteItemNotFoundException;
import com.test.voating.models.entity.VoteRoom;

public interface VoteRoomService {

	public VoteRoom findById(int id) throws VoteItemNotFoundException;

	public VoteRoom addVoteRoom(VoteRoom room) throws VoteIllegalStateException, VoteItemCreationException, VoteItemNotFoundException;

	public VoteRoom updateVoteRoom(VoteRoom room) throws VoteIllegalStateException, VoteItemCreationException, VoteItemNotFoundException;

	public List<VoteRoom> findAll();

	public VoteRoom setStatus(int id, boolean b) throws VoteBasicException;

}

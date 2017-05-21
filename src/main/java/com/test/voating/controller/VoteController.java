package com.test.voating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.voating.exceptions.VoteIllegalStateException;
import com.test.voating.exceptions.VoteItemNotFoundException;
import com.test.voating.models.entity.Vote;
import com.test.voating.service.VotingService;

@RestController
@RequestMapping(value = "/votes")
public class VoteController extends AbstarctController {

    @Autowired
    private VotingService vService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Vote> getVotes() {
	List<Vote> votes = vService.findAll();
	return votes;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Vote> getVote(@PathVariable int id) throws VoteItemNotFoundException {
	Vote v = vService.findById(id);
	return getResponse(v);
    }

    @RequestMapping(value = "/rooms/{roomId}/answers/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Vote>> getVotesByAnswer(@PathVariable int id, @PathVariable int roomId) throws VoteItemNotFoundException {
	List<Vote> v = vService.findByAnswerAndRoomId(id, roomId);
	return getResponse(v);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Vote> addVote(Vote vote) throws VoteIllegalStateException, VoteItemNotFoundException {
	Vote v = vService.makeVote(vote);
	return getResponse(v);
    }

    @RequestMapping(value = "/rooms/{id}", method = RequestMethod.POST)
    public ResponseEntity<Vote> addVoteByRoom(@PathVariable int id, @RequestBody int answerId ) throws VoteIllegalStateException, VoteItemNotFoundException {
	Vote v = vService.addVoteByRoom(id, answerId);
	return getResponse(v, HttpStatus.CREATED);
    }
     
}

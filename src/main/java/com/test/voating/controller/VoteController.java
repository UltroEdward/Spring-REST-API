package com.test.voating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.voating.models.entity.Vote;
import com.test.voating.service.VotingService;

@RestController
@RequestMapping(value = "/vote")
public class VoteController extends AbstarctController {

	@Autowired
	private VotingService voteService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Vote> getVotes() {
		List<Vote> votes = voteService.findAll();
		return votes;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vote> getVote(@PathVariable int id) {
		Vote v = voteService.findById(id);
		return getResponse(v, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/answer/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Vote>> getVotesByAnswer(@PathVariable int id) {
		List<Vote> v = voteService.findByAnswerId(id);
		return getResponse(v, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Vote> addVote(Vote vote) {
		Vote v = voteService.makeVote(vote);
		return getResponse(v, HttpStatus.BAD_REQUEST);
	}
	
	
}

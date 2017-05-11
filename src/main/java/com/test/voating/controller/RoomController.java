package com.test.voating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.voating.model.VoteRoom;
import com.test.voating.service.VoteService;

@RestController
@RequestMapping(value = "/rooms")
public class RoomController {

	@Autowired
	private VoteService voteService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<VoteRoom>> getRooms() {
		List<VoteRoom> userDetails = voteService.getVoteRooms();
		return new ResponseEntity<List<VoteRoom>>(userDetails, HttpStatus.OK);
	}

}
package com.test.voating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.voating.entity.VoteRoom;
import com.test.voating.service.VoteRoomService;

@RestController
@RequestMapping(value = "/rooms")
public class RoomsController extends AbstarctController {

	@Autowired
	private VoteRoomService voteService;

	@RequestMapping(method = RequestMethod.GET)
	public List<VoteRoom> getRooms() {
		List<VoteRoom> userDetails = voteService.findAll();
		return userDetails;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<VoteRoom> getRoom(@PathVariable int id) {
		VoteRoom r = voteService.findById(id);
		return getResponse(r, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<VoteRoom> addRoom(VoteRoom room) {
		VoteRoom r = voteService.addVoteRoom(room);
		return getResponse(r, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<VoteRoom> updateRoomStatus(@PathVariable int id, boolean isOpened) {
		VoteRoom room = voteService.findById(id);
		if (room == null) {
			return null;
		}
		room.setIsOpened(isOpened);
		VoteRoom r = voteService.updateVoteRoom(room);
		return getResponse(r, HttpStatus.BAD_REQUEST);
	}

}
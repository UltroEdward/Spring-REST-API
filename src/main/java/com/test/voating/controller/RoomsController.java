package com.test.voating.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.voating.exceptions.VoteBasicException;
import com.test.voating.models.dto.CommonDTO;
import com.test.voating.models.entity.VoteRoom;
import com.test.voating.service.VoteRoomService;
import com.test.voating.utils.URLUtils;

@RestController
@RequestMapping(value = "/rooms")
public class RoomsController extends AbstarctController {

    @Autowired
    private VoteRoomService voteRoomService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<VoteRoom>> getRooms() {
	List<VoteRoom> userDetails = voteRoomService.findAll();
	return getResponse(userDetails);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<VoteRoom> getRoom(@PathVariable int id) throws VoteBasicException {
	VoteRoom room = voteRoomService.findById(id);
	return getResponse(room);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<VoteRoom> addRoom(@RequestBody VoteRoom room) throws VoteBasicException {
	room = voteRoomService.addVoteRoom(room);
	return getResponse(room, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/run", method = RequestMethod.GET)
    public ResponseEntity<CommonDTO> runRoom(@PathVariable int id, HttpServletRequest request) throws VoteBasicException {
	voteRoomService.setStatus(id, true);

	CommonDTO dto = new CommonDTO();
	dto.setKey("Vote URL");
	dto.setValue(URLUtils.getBaseUrl(request) + String.format("votes/rooms/%d", id));

	return getResponse(dto);
    }

    @RequestMapping(value = "/{id}/close", method = RequestMethod.GET)
    public ResponseEntity<String> closeRoom(@PathVariable int id) throws VoteBasicException {
	VoteRoom room = voteRoomService.setStatus(id, false);
	return getResponse("Room closed: " + room.toString());
    }

}
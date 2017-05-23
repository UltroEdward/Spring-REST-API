package com.test.voating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.voating.exceptions.VoteBasicException;
import com.test.voating.models.dto.StatDTO;
import com.test.voating.service.StatService;

@RestController
@RequestMapping(value = "/stats")
public class StatController extends AbstarctController {

    @Autowired
    private StatService sService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<StatDTO> getStats(@PathVariable int id) throws VoteBasicException {
	StatDTO s = sService.getStats(id);
	return getResponse(s);
    }
}

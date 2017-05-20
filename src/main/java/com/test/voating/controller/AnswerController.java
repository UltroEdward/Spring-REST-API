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
import com.test.voating.exceptions.VoteItemCreationException;
import com.test.voating.exceptions.VoteItemNotFoundException;
import com.test.voating.models.entity.Answer;
import com.test.voating.service.AnswerService;

@RestController
@RequestMapping(value = "/answers")
public class AnswerController extends AbstarctController {

    @Autowired
    private AnswerService aService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Answer>> getAnswers() {
	List<Answer> answers = aService.findAll();
	return getResponse(answers);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Answer> getAnswer(@PathVariable int id) throws VoteItemNotFoundException {
	Answer answer = aService.findById(id);
	return getResponse(answer);
    }

    @RequestMapping(value = "/questions/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Answer>> getAnswersByQuestionId(@PathVariable int id) throws VoteItemNotFoundException {
	List<Answer> answers = aService.selectedByQuestionId(id);
	return getResponse(answers);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Answer> addAnswer(@RequestBody Answer answerToSave) throws VoteItemCreationException, VoteIllegalStateException, VoteItemNotFoundException {
	Answer answer = aService.addAnswer(answerToSave);
	return getResponse(answer, HttpStatus.CREATED);
    }

}

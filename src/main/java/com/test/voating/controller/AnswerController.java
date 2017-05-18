package com.test.voating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.voating.entity.Answer;
import com.test.voating.service.AnswerService;

@RestController
@RequestMapping(value = "/answers")
public class AnswerController extends AbstarctController {

	@Autowired
	private AnswerService aService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Answer> getAnswers() {
		List<Answer> answers = aService.findAll();
		return answers;
	}

	@RequestMapping(value = "/questions/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Answer>> getAnswersByQuestionId(@PathVariable int id) {
		List<Answer> answers = aService.selectedByQuestionId(id);
		return getResponse(answers, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Answer> getAnswer(@PathVariable int id) {
		Answer r = aService.findById(id);
		return getResponse(r, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Answer> addAnswer(Answer answer) {
		Answer a = aService.addAnswer(answer);
		return getResponse(a, HttpStatus.BAD_REQUEST);
	}

}

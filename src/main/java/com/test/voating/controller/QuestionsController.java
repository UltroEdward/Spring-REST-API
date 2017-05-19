package com.test.voating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.voating.models.entity.Question;
import com.test.voating.service.QuestionService;

@RestController
@RequestMapping(value = "/questions")
public class QuestionsController extends AbstarctController {

	@Autowired
	private QuestionService qService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Question>> getQuestions() {
		List<Question> questions = qService.findAll();
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Question> getQuestion(@PathVariable int id) {
		Question q = qService.findById(id);
		return getResponse(q, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Question> addQuestion(Question question) {
		Question q = qService.addQuestion(question);
		return getResponse(q,HttpStatus.BAD_REQUEST);
	}

}
package com.test.voating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.voating.model.Question;
import com.test.voating.service.QuestionService;

@RestController
@RequestMapping(value = "/questions")
public class QuestionsController {

	@Autowired
	private QuestionService qService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Question> getQuestions() {
		List<Question> questions = qService.findAll();
		return questions;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Question getQuestion(@PathVariable int id) {
		return qService.findById(id);
	}

}
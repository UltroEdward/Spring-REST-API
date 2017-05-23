package com.test.voating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.voating.exceptions.VoteBasicException;
import com.test.voating.models.entity.Question;
import com.test.voating.service.QuestionService;

@RestController
@RequestMapping(value = "/questions")
public class QuestionsController extends AbstarctController {

    @Autowired
    private QuestionService qService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Question>> getQuestions() throws VoteBasicException {
	List<Question> questions = qService.findAll();
	return getResponse(questions);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Question> getQuestion(@PathVariable int id) throws VoteBasicException {
	Question question = qService.findById(id);
	return getResponse(question);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Question> addQuestion(Question questionToSave) throws VoteBasicException {
	Question question = qService.addQuestion(questionToSave);
	return getResponse(question, HttpStatus.CREATED);
    }

}
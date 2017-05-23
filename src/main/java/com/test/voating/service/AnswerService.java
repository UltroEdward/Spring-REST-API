package com.test.voating.service;

import java.util.List;

import com.test.voating.exceptions.VoteBasicException;
import com.test.voating.models.entity.Answer;

public interface AnswerService {

	public Answer findById(int id) throws VoteBasicException;

	public Answer addAnswer(Answer answer) throws  VoteBasicException;

	public List<Answer> findAll();
	
	public List<Answer> selectedByQuestionId(int id) throws VoteBasicException;
	
}

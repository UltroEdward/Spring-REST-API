package com.test.voating.service;

import java.util.List;

import com.test.voating.exceptions.VoteIllegalStateException;
import com.test.voating.exceptions.VoteItemCreationException;
import com.test.voating.exceptions.VoteItemNotFoundException;
import com.test.voating.models.entity.Answer;

public interface AnswerService {

	public Answer findById(int id) throws VoteItemNotFoundException;

	public Answer addAnswer(Answer answer) throws  VoteIllegalStateException, VoteItemCreationException, VoteItemNotFoundException;

	public List<Answer> findAll();
	
	public List<Answer> selectedByQuestionId(int id) throws VoteItemNotFoundException;
	
}

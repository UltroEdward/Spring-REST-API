package com.test.voating.service;

import java.util.List;

import com.test.voating.models.entity.Answer;

public interface AnswerService {

	public Answer findById(int id);

	public Answer addAnswer(Answer answer);

	public List<Answer> findAll();
	
	public List<Answer> selectedByQuestionId(int id);
	
}

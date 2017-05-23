package com.test.voating.service;

import java.util.List;

import com.test.voating.exceptions.VoteBasicException;
import com.test.voating.models.entity.Question;

public interface QuestionService {

	public Question findById(int id) throws VoteBasicException;

	public Question addQuestion(Question question) throws VoteBasicException;

	public List<Question> findAll();
}

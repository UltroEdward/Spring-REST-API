package com.test.voating.service;

import java.util.List;

import com.test.voating.exceptions.VoteIllegalStateException;
import com.test.voating.exceptions.VoteItemCreationException;
import com.test.voating.exceptions.VoteItemNotFoundException;
import com.test.voating.models.entity.Question;

public interface QuestionService {

	public Question findById(int id) throws VoteItemNotFoundException;

	public Question addQuestion(Question question) throws VoteIllegalStateException, VoteItemCreationException;

	public List<Question> findAll();
}

package com.test.voating.service;

import java.util.List;

import com.test.voating.models.entity.Question;

public interface QuestionService {

	public Question findById(int id);

	public Question addQuestion(Question question);

	public List<Question> findAll();
}

package com.test.voating.service;

import java.util.List;

import com.test.voating.model.Question;

public interface QuestionService {

	public Question findById(int id);

	public List<Question> findAll();
}

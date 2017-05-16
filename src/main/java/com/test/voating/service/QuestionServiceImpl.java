package com.test.voating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.voating.dao.QuestionDAO;
import com.test.voating.model.Question;

@Component
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDAO questionDao;

	public Question findById(int id) {
		return questionDao.findOne(id);
	}

	public List<Question> findAll() {
		return questionDao.findAll();
	}

}

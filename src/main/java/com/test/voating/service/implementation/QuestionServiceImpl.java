package com.test.voating.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.voating.dao.QuestionDAO;
import com.test.voating.models.entity.Question;
import com.test.voating.service.QuestionService;

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

	public Question addQuestion(Question question) {
		question.setId(0); // let db generate id
		if (question.getName() == null) {
			return null;
		}
		Question roomSaved = questionDao.saveAndFlush(question);
		return roomSaved;
	}

}

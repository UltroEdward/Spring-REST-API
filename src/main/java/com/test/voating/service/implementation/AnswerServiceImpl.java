package com.test.voating.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.voating.dao.AnswerDAO;
import com.test.voating.dao.QuestionDAO;
import com.test.voating.entity.Answer;
import com.test.voating.entity.Question;
import com.test.voating.service.AnswerService;

@Component
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerDAO answerDao;
	@Autowired
	private QuestionDAO questionDao;

	@Override
	public Answer findById(int id) {
		return answerDao.findOne(id);
	}

	@Override
	public Answer addAnswer(Answer answer) {
		answer.setId(0); // let db generate id
		if (answer.getName() == null) {
			return null;
		}
		Answer ans = answerDao.saveAndFlush(answer);
		return ans;
	}

	@Override
	public List<Answer> findAll() {
		return answerDao.findAll();
	}

	@Override
	public List<Answer> selectedByQuestionId(int id) {
		Question qestion = questionDao.getOne(id);
		if (qestion == null) {
			return null;
		}
		return answerDao.selectByQuestionId(id);
	}

}

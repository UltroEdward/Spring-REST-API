package com.test.voating.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.voating.dao.AnswerDAO;
import com.test.voating.exceptions.VoteIllegalStateException;
import com.test.voating.exceptions.VoteItemCreationException;
import com.test.voating.exceptions.VoteItemNotFoundException;
import com.test.voating.models.entity.Answer;
import com.test.voating.models.entity.Question;
import com.test.voating.service.AnswerService;
import com.test.voating.service.QuestionService;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerDAO answerDao;
    @Autowired
    private QuestionService questionService;

    @Override
    public Answer findById(int id) throws VoteItemNotFoundException {
	Answer answer = answerDao.findOne(id);
	try {
	    answer.getId();
	} catch (Exception ex) {
	    throw new VoteItemNotFoundException("Answer id is incorrect or not exist");
	}
	return answer;
    }

    @Override
    public Answer addAnswer(Answer answer) throws VoteIllegalStateException, VoteItemCreationException, VoteItemNotFoundException {
	answer.setId(0); // let db generate id
	if (answer.getName() == null || answer.getName().isEmpty()) {
	    throw new VoteIllegalStateException("Answer name is empty, can't add");
	}
	questionService.findById(answer.getQuestionId());

	Answer ans = null;
	try {
	    ans = answerDao.saveAndFlush(answer);
	} catch (Exception ex) {
	    throw new VoteItemCreationException("Can't add Answer: " + ex.getMessage());
	}
	return ans;
    }

    @Override
    public List<Answer> findAll() {
	return answerDao.findAll();
    }

    @Override
    public List<Answer> selectedByQuestionId(int id) throws VoteItemNotFoundException {

	Question qestion = questionService.findById(id);
	try {
	    qestion.getId();
	} catch (Exception ex) {
	    throw new VoteItemNotFoundException("Question id is incorrect or not exist");
	}
	return answerDao.selectByQuestionId(id);
    }

}

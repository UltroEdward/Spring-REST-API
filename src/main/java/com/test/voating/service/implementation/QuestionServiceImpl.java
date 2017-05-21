package com.test.voating.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.voating.dao.QuestionDAO;
import com.test.voating.exceptions.VoteIllegalStateException;
import com.test.voating.exceptions.VoteItemCreationException;
import com.test.voating.exceptions.VoteItemNotFoundException;
import com.test.voating.models.entity.Question;
import com.test.voating.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDAO questionDao;

    public Question findById(int id) throws VoteItemNotFoundException {
	Question question = questionDao.findOne(id);
	try {
	    question.getId();
	} catch (Exception ex) {
	    throw new VoteItemNotFoundException("Question id is incorrect or not exist");
	}
	return question;
    }

    public List<Question> findAll() {
	return questionDao.findAll();
    }

    public Question addQuestion(Question questionToSave) throws VoteIllegalStateException, VoteItemCreationException {
	questionToSave.setId(0); // let db generate id
	if (questionToSave.getName() == null || questionToSave.getName().isEmpty()) {
	    throw new VoteIllegalStateException("Question name is empty, can't add");
	}

	Question question = null;
	try {
	    question = questionDao.saveAndFlush(questionToSave);
	} catch (Exception ex) {
	    throw new VoteItemCreationException("Can't add Question: " + ex.getMessage());
	}

	return question;
    }

}

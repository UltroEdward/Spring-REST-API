package com.test.voating.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.voating.model.Question;

public interface QuestionDAO extends JpaRepository<Question, Integer> {

	public Question findById(int id);

	public List<Question> findAll();
}

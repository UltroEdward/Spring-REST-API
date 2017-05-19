package com.test.voating.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.voating.models.entity.Answer;

public interface AnswerDAO extends JpaRepository<Answer, Integer> {

	@Query("select a from Answer a where a.questionId = :id")
	List<Answer> selectByQuestionId(@Param("id") int id);
}

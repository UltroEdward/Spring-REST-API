package com.test.voating.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.voating.models.entity.Question;

public interface QuestionDAO extends JpaRepository<Question, Integer> {

}

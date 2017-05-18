package com.test.voating.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.voating.entity.Question;

public interface QuestionDAO extends JpaRepository<Question, Integer> {

}

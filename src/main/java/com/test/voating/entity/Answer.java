package com.test.voating.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ANSWERS")
public class Answer {

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "QUESTION_ID", nullable = false)
	private int questionId;

	@Column(name = "ANSWER", nullable = false)
	private int answer;
	
	@Column(name = "USER", nullable = false)
	private String name;

}

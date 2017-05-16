package com.test.voating.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VOTES")
public class Vote {

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ROOM_ID", nullable = false)
	private int roomId;

	@Column(name = "ANSWER_ID", nullable = false)
	private int answerId;
}

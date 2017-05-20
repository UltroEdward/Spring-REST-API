package com.test.voating.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VOTE_ROOMS")
public class VoteRoom {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "IS_OPENED", nullable = false)
    private boolean isOpened;

    @Column(name = "ID_QUESTION", nullable = false)
    private int idQuestion;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getIdQuestion() {
	return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
	this.idQuestion = idQuestion;
    }

    public boolean isOpened() {
	return isOpened;
    }

    public void setOpened(boolean isOpened) {
	this.isOpened = isOpened;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("ROOM:");
	builder.append(" id " + id);
	builder.append(" name " + name);
	builder.append(" isOpened " + isOpened);
	return builder.toString();
    }

}

package com.test.voating.models.entity;

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

    @Column(name = "ID_ROOM", nullable = false)
    private int roomId;

    @Column(name = "ID_ANSWER", nullable = false)
    private int answerId;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getRoomId() {
	return roomId;
    }

    public void setRoomId(int roomId) {
	this.roomId = roomId;
    }

    public int getAnswerId() {
	return answerId;
    }

    public void setAnswerId(int answerId) {
	this.answerId = answerId;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("VOTE: ");
	builder.append("id " + id);
	builder.append(", room " + roomId);
	builder.append(", answer " + answerId);
	return builder.toString();
    }
}

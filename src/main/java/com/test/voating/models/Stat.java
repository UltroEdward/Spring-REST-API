package com.test.voating.models;

import java.util.List;

public class Stat {

	private String question;
	private List<StatItem> items;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<StatItem> getItems() {
		return items;
	}

	public void setItems(List<StatItem> items) {
		this.items = items;
	}

}

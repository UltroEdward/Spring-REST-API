package com.test.voating.models.dto;

import java.util.List;

public class StatDTO {

	private String question;
	private List<StatItemDTO> items;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<StatItemDTO> getItems() {
		return items;
	}

	public void setItems(List<StatItemDTO> items) {
		this.items = items;
	}

}

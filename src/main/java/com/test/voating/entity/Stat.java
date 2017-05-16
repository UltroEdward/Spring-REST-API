package com.test.voating.entity;

import java.util.List;

public class Stat {

	private String question;
	private List<StatItem> items;

	public class StatItem {
		private String answer;
		private int count;
	}
}

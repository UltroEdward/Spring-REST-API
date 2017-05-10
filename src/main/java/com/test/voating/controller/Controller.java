package com.test.voating.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class Controller {

	@RequestMapping("/")
	public String goGet() {
		return "hello world";
	}

}
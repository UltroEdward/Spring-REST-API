package com.test.voating.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AbstarctController {

	protected <E> ResponseEntity<E> getResponse(E respBody, HttpStatus inCaseOfEmpty) {

		if (respBody == null) {
			return new ResponseEntity<>(respBody, inCaseOfEmpty);
		}
		if (respBody instanceof Collection<?>) {
			if (((Collection<?>) respBody).isEmpty()) {
				return new ResponseEntity<>(respBody, inCaseOfEmpty);
			}
		}
		return new ResponseEntity<>(respBody, HttpStatus.OK);
	}

}

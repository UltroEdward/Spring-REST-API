package com.test.voating.exceptions;

public class VoteItemNotFoundException extends VoteBasicException {

	private static final long serialVersionUID = 1L;

	public VoteItemNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}

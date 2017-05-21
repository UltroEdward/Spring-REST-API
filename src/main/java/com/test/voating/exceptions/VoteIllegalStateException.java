package com.test.voating.exceptions;

public class VoteIllegalStateException extends VoteBasicException {

    private static final long serialVersionUID = 1L;

    public VoteIllegalStateException(String errorMessage) {
	super(errorMessage);
    }
}

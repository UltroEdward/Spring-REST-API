package com.test.voating.exceptions;

public class VoteItemCreationException extends VoteBasicException {

    private static final long serialVersionUID = 1L;

    public VoteItemCreationException(String errorMessage) {
	super(errorMessage);
    }

}

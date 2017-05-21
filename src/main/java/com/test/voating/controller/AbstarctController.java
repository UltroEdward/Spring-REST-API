package com.test.voating.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.test.voating.exceptions.VoteBasicException;
import com.test.voating.exceptions.VoteIllegalStateException;
import com.test.voating.exceptions.VoteItemCreationException;
import com.test.voating.exceptions.VoteItemNotFoundException;
import com.test.voating.models.dto.ErrorDataDTO;

public abstract class AbstarctController {

    public static final Logger LOG = LoggerFactory.getLogger(AbstarctController.class);

    protected <E> ResponseEntity<E> getResponse(E respBody, HttpStatus status) {
	return new ResponseEntity<>(respBody, status);
    }

    protected <E> ResponseEntity<E> getResponse(E respBody) {
	return getResponse(respBody, HttpStatus.OK);
    }

    @ExceptionHandler(VoteBasicException.class)
    protected ResponseEntity<ErrorDataDTO> exceptionHandler(Exception ex) {
	ErrorDataDTO error = new ErrorDataDTO();
	error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
	error.setMessage(ex.getMessage());
	
	StringWriter sw = new StringWriter();
	ex.printStackTrace(new PrintWriter(sw));
	LOG.error(ex.getMessage());
	LOG.error(sw.toString());

	if (ex instanceof VoteItemNotFoundException) {
	    return new ResponseEntity<ErrorDataDTO>(error, HttpStatus.NOT_FOUND);
	}
	if (ex instanceof VoteItemCreationException) {
	    return new ResponseEntity<ErrorDataDTO>(error, HttpStatus.BAD_REQUEST);
	}
	if (ex instanceof VoteIllegalStateException) {
	    return new ResponseEntity<ErrorDataDTO>(error, HttpStatus.BAD_REQUEST);
	}

	return new ResponseEntity<ErrorDataDTO>(error, HttpStatus.OK);
    }

}

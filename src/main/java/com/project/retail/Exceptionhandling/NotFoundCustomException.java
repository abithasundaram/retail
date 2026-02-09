package com.project.retail.Exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundCustomException extends RuntimeException{
	
	public NotFoundCustomException() {
		super();
	}
	
	public NotFoundCustomException(String message) {
		super(message);
	}

}

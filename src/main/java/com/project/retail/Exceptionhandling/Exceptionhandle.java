package com.project.retail.Exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class Exceptionhandle {

	@ExceptionHandler(NotFoundCustomException.class)
	public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundCustomException ex,HttpServletRequest request){
		
		ErrorResponse errorres = new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage(),request.getRequestURI());
		return new ResponseEntity<ErrorResponse>(errorres,HttpStatus.NOT_FOUND);
				
	}
		
	
}

package com.nt.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.exception.ActorNotFoundException;
import com.nt.model.ErrorDetails;

@RestControllerAdvice
public class ActorControllerAdvice {
	
	//specific error handling
	
	@ExceptionHandler(ActorNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleActorNotFoundException(ActorNotFoundException ancf){
		System.out.println(
				"ActorControllerAdvice.handleActorNotFoundException()");
			ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),"500",ancf.getMessage() );
			return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//For all other exception
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllException(Exception e){
		System.out.println("ActorControllerAdvice.handleAllException()");
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "500");
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

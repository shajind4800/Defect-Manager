package com.example.defect.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Object> handleBadRequestException(BadRequestException errorResponse) {

		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode(HttpStatus.BAD_REQUEST.name());
		response.setErrorMessage(errorResponse.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);

	}

}
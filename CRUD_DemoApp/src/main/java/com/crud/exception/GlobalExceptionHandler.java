package com.crud.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(MovieNotFoundException exception, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<?> servletMissingException(MissingServletRequestParameterException exception,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(new Date(),
				"Sorry! You provide Bad Request URL.Make sure it is correct or not.", request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<?> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(new Date(),
				"Sorry! Requested method not supported. Make sure it is correct or not.", request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(EmptyMovieListException.class)
	public ResponseEntity<?> emptymovieListException(EmptyMovieListException exception, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(new Date(), exception.getMessage(),
				request.getDescription(false));
		// System.err.println(exception.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MovieAlreadyExist.class)
	public ResponseEntity<?> movieAlreadyExistException(MovieAlreadyExist exception, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(new Date(), exception.getMessage(),
				request.getDescription(false));
		// System.err.println(exception.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalException(Exception exception, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(new Date(), exception.getMessage(),
				request.getDescription(false));
		// System.err.println(exception.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}

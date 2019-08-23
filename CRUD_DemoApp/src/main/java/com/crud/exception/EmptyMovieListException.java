package com.crud.exception;

public class EmptyMovieListException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyMovieListException(String message) {
		super(message);
	}
}

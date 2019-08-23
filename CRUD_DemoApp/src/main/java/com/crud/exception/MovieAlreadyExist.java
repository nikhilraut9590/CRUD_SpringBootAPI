package com.crud.exception;

public class MovieAlreadyExist extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MovieAlreadyExist(String message) {
		super(message);
	}
}

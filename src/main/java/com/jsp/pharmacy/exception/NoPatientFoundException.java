package com.jsp.pharmacy.exception;

public class NoPatientFoundException extends RuntimeException {

	private final String message;

	public String getMessage() {
		return message;
	}

	public NoPatientFoundException(String message) {
		super();
		this.message = message;
	}
	
	
}

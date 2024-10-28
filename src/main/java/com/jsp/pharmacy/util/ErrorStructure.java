package com.jsp.pharmacy.util;

public class ErrorStructure<T> {

	private int statusCode;
	private String message;
	private T rootCause;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getRootCause() {
		return rootCause;
	}
	public void setRootCause(T rootCause) {
		this.rootCause = rootCause;
	}
	
	public static <T> ErrorStructure<T> create(int statusCode,String message,T data){
		
		ErrorStructure<T> errorStructure = new ErrorStructure<T>();
		errorStructure.setStatusCode(statusCode);
		errorStructure.setMessage(message);
		errorStructure.setRootCause(data);
		return errorStructure;
	}
}

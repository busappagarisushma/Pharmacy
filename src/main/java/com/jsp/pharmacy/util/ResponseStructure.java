package com.jsp.pharmacy.util;

import org.springframework.http.HttpStatus;

public class ResponseStructure<T> {

	private int statuscode;
	private String message;
	private  T data;
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	public static <T>  ResponseStructure<T> create(HttpStatus statusCode, String message,T data){
		ResponseStructure<T> responseStructure = new ResponseStructure<T>();
		responseStructure.setStatuscode(statusCode.value());
		responseStructure.setMessage(message);
		responseStructure.setData(data);
		return responseStructure;
	}
}

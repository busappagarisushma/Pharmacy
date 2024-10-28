package com.jsp.pharmacy.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AppResponseBuilder<T> {

	public <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus statusCode,String mesage,T data){
		return ResponseEntity.status(statusCode)
				.body(ResponseStructure.create(statusCode, mesage, data));
	}

	public <T> ResponseEntity<ErrorStructure<T>> error(HttpStatus status,String message,T rootCause){
		return ResponseEntity
				.status(status)
				.body(ErrorStructure.create(status.value(), message, rootCause));
	}
}

package com.jsp.pharmacy.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.pharmacy.exception.PharmacyNotFoundByIdException;
import com.jsp.pharmacy.util.AppResponseBuilder;
import com.jsp.pharmacy.util.ErrorStructure;

@RestControllerAdvice
public class PharmacyExceptionHandler {

	private final AppResponseBuilder appResponseBuilder;

	public PharmacyExceptionHandler(AppResponseBuilder appResponseBuilder) {
		super();
		this.appResponseBuilder = appResponseBuilder;
	}
	
	@ExceptionHandler(PharmacyNotFoundByIdException.class)
	public  ResponseEntity<ErrorStructure<String>> hanldePharmacyNotFoundById(PharmacyNotFoundByIdException ex){
		return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "pharmacy not found in db");
	}
}

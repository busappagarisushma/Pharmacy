package com.jsp.pharmacy.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.pharmacy.exception.AdminNotFoundByIdException;
import com.jsp.pharmacy.util.AppResponseBuilder;
import com.jsp.pharmacy.util.ErrorStructure;

@RestControllerAdvice
public class AdminExceptionHandler {

	private final AppResponseBuilder appResponseBuilder;

	public AdminExceptionHandler(AppResponseBuilder appResponseBuilder) {
		super();
		this.appResponseBuilder = appResponseBuilder;
	}

	@ExceptionHandler(AdminNotFoundByIdException.class)
	public  ResponseEntity<ErrorStructure<String>> hanldeAdminNotFoundById(AdminNotFoundByIdException ex){
		return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "admin not found in db");
	}
}

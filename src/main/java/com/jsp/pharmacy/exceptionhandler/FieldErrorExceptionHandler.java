package com.jsp.pharmacy.exceptionhandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.pharmacy.util.ErrorStructure;

@RestControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		List<ObjectError> errors = ex.getAllErrors();

		List<FieldErrorStructure> errorResponses = new ArrayList<>();
		for(ObjectError error : errors) {
			FieldError fieldError = (FieldError) error;
			String message = fieldError.getDefaultMessage();
			String field = fieldError.getField();
			Object rejectedValue = fieldError.getRejectedValue();

			FieldErrorStructure structure = new FieldErrorStructure(message,field,rejectedValue);
			errorResponses.add(structure);
		}

		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(ErrorStructure.create(HttpStatus.BAD_REQUEST.value(), "Invalid INput", errorResponses));
	}


}

class FieldErrorStructure{

	private String message;
	private String field;
	private Object RejectedValue;

	public FieldErrorStructure(String message, String field, Object rejectedValue) {
		super();
		this.message = message;
		this.field = field;
		RejectedValue = rejectedValue;
	}

	public String getMessage() {
		return message;
	}

	public String getField() {
		return field;
	}

	public Object getRejectedValue() {
		return RejectedValue;
	}



}

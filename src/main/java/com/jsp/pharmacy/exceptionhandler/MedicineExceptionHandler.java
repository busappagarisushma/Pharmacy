package com.jsp.pharmacy.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jsp.pharmacy.exception.AdminNotFoundByIdException;
import com.jsp.pharmacy.exception.NoMedicineFoundException;
import com.jsp.pharmacy.util.AppResponseBuilder;
import com.jsp.pharmacy.util.ErrorStructure;

@ControllerAdvice
public class MedicineExceptionHandler {

	private final AppResponseBuilder appResponseBuilder;

	public MedicineExceptionHandler(AppResponseBuilder appResponseBuilder) {
		super();
		this.appResponseBuilder = appResponseBuilder;
	}


	@ExceptionHandler(NoMedicineFoundException.class)
	public ResponseEntity<ErrorStructure<String>> handleNoMedicineFound(NoMedicineFoundException ex){
		return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "medicine not found");
	}

}

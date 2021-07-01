package com.lakkam.springrestproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lakkam.springrestproject.entity.response.EmployeeResponseError;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<EmployeeResponseError> handleEmployeeException(EmployeeNotFoundException exe) {
		EmployeeResponseError employeeRes = new EmployeeResponseError();
		employeeRes.setStatus(HttpStatus.NOT_FOUND.value());
		employeeRes.setMessage("Employee Not Found");
		employeeRes.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<EmployeeResponseError>(employeeRes, HttpStatus.NOT_FOUND);

	}

}

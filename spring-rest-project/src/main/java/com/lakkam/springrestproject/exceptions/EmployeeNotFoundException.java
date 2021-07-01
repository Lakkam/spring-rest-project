package com.lakkam.springrestproject.exceptions;

public class EmployeeNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2502191598576425269L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}

}

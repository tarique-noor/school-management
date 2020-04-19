package com.tariq.springboot.schoolmanagement.exception;

public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException(String message, Throwable mycase) {
		super(message, mycase);
	}

	public CustomerNotFoundException(String message) {
		super(message);
	}

	public CustomerNotFoundException(Throwable mycase) {
		super(mycase);
	}

}

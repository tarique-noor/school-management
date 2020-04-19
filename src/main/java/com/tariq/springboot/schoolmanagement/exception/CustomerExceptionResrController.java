package com.tariq.springboot.schoolmanagement.exception;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerExceptionResrController {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss a");
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> exceptionHandle(CustomerNotFoundException exc)
	{
		
		CustomerErrorResponse res = new CustomerErrorResponse();
		
		res.setStatus(HttpStatus.NOT_FOUND.value());
		res.setMessage(exc.getMessage());
		res.setTimeStamp(sdf.format(new Date()));
		
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> exceptionHandle(Exception exc)
	{
		
		CustomerErrorResponse res = new CustomerErrorResponse();
		
		res.setStatus(HttpStatus.BAD_REQUEST.value());
		res.setMessage(exc.getMessage());
		res.setTimeStamp(sdf.format(new Date()));
		
		return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
	}
}

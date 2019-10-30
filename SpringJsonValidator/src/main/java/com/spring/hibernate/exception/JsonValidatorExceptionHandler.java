package com.spring.hibernate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.hibernate.model.Response;

@ControllerAdvice
public class JsonValidatorExceptionHandler {
	
	@ExceptionHandler(JsonValidatorException.class)
	public ResponseEntity<Response> validator(JsonValidatorException ex){
		Response res=new Response();
		res.setMessage(ex.getMessage());
		res.setStatusCode(HttpStatus.BAD_REQUEST.value());
		res.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
	}

}

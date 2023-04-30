package com.dabel.apirestwithmysql.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dabel.apirestwithmysql.model.CourseErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@Order(value = Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<Object> noReadableEception(HttpServletRequest request, CourseNotFoundException ex) {
		
		CourseErrorResponse cErrorResponse = new CourseErrorResponse(
				ex.getMessage(), 
				request.getMethod(), 
				request.getRequestURL().toString()
				);
		return new ResponseEntity<Object>(cErrorResponse, HttpStatus.NOT_FOUND);
	}
}

package com.dabel.apirestwithmysql.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dabel.apirestwithmysql.exception.CourseNotFoundException;

/**
 * Configure our advice controller to catch all 
 * exceptions from a not found course
 * 
 * @author ABDEL-NASSER BEN ALI
 *
 */
@ControllerAdvice
public class CourseControllerAdvice {

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String courseNotFoundHandlerException(CourseNotFoundException exception) {
		return exception.getMessage();
	}
}

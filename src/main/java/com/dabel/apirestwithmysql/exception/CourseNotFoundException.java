package com.dabel.apirestwithmysql.exception;

/**
 * Exception class for requests to a non-existent course 
 * 
 * @author ABDEL-NASSER BEN ALI
 *
 */
@SuppressWarnings("serial")
public class CourseNotFoundException extends RuntimeException {

	public CourseNotFoundException(String message) {
		super(message);
	}
}

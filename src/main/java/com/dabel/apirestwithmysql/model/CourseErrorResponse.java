package com.dabel.apirestwithmysql.model;

import lombok.Data;

@Data
public class CourseErrorResponse {

	String message;
	String method;
	String path;
	
	public CourseErrorResponse(String message, String method, String path) {
	
		this.message = message;
		this.method = method;
		this.path = path;
	}
	
}

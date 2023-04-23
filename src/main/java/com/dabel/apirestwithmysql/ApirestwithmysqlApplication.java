package com.dabel.apirestwithmysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dabel.apirestwithmysql.repository.CourseRepository;

@SpringBootApplication
public class ApirestwithmysqlApplication {

	@Autowired
	CourseRepository repository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ApirestwithmysqlApplication.class, args);
	}

}

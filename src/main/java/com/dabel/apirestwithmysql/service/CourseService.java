package com.dabel.apirestwithmysql.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.dabel.apirestwithmysql.model.Course;
import com.dabel.apirestwithmysql.repository.CourseRepository;

/**
 * Class to apply the business and management 
 * rules of the application
 * 
 * @author ABDEL-NASSER BEN ALI
 *
 */
@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> findAll() {
		return courseRepository.findAll();
	}
	
	public Optional<Course> findById(int id) {
		return courseRepository.findById(id);
	}
	
	public Course save(Course course) {
		return courseRepository.save(course);
	}
	
	public Course updatePartially(int id, java.util.Map<String, Object> fields) {
		
		Course course = courseRepository.findById(id).get();
		
		fields.forEach((key, value) -> {
			
			Field field = ReflectionUtils.findRequiredField(Course.class, key);
			ReflectionUtils.setField(field, course, value);
		});
		
		return courseRepository.save(course);
	}
	
	public void deleteById(int id) {
		courseRepository.deleteById(id);
	}
	
	
}
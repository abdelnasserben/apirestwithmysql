package com.dabel.apirestwithmysql.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dabel.apirestwithmysql.exception.CourseNotFoundException;
import com.dabel.apirestwithmysql.model.Course;
import com.dabel.apirestwithmysql.service.CourseService;


/**
 * Rest controller class to map HTTP verbs
 * 
 * @author ABDEL-NASSER BEN ALI
 *
 */
@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/")
	public ResponseEntity<List<Course>> getAllCourses() {
		
		List<Course> course = courseService.findAll();
		
		if(!course.iterator().hasNext())
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.ok(course);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable int id) {
		
		Course checkCourse = courseService.findById(id).orElseThrow(
					() -> new CourseNotFoundException("Cours introuvable !")
				);
				
		return ResponseEntity.ok(checkCourse);
	}
	
	@PostMapping("/")
	public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
		
		Course savedCourse = courseService.save(course);
		return new ResponseEntity<Course>(savedCourse, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCourse(@PathVariable int id, @RequestBody Course course) {
		
		Course checkCourse = courseService.findById(id).orElseThrow(
					() -> new CourseNotFoundException("Identifiant inexistant !")
				);
		
		//update course id to be replaced content
		course.setId(checkCourse.getId());
		courseService.save(course);
		
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Object> updateCoursePartially(@PathVariable int id, @RequestBody Map<String, Object> fields) {
		
		courseService.findById(id).orElseThrow(
					() -> new CourseNotFoundException("Identifiant inexistant !")
				);
		
		courseService.updatePartially(id, fields);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCourse(@PathVariable int id) {
		
		courseService.findById(id).orElseThrow(
					() -> new CourseNotFoundException("Identifiant inexistant !")
				);
		
		courseService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}

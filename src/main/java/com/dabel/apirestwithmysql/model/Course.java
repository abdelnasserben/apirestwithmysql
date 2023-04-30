package com.dabel.apirestwithmysql.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.tuple.GenerationTiming;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Simple POJO to represent a course in the 
 * courses entity of the database
 * 
 * @author ABDEL-NASSER BEN ALI
 *
 */
@Data
@Entity
@Table(name="courses")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String title;
	private String description;
	private String category;
	private String level;
	
	@CurrentTimestamp(timing = GenerationTiming.INSERT)
	private LocalDateTime postedAt;
	
	public Course() {
		
	}
	
	public Course(String title, String description, String category, String level) {
		this.title = title;
		this.description = description;
		this.category = category;
		this.level = level;
	}
	
	
		
}

package com.dabel.apirestwithmysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dabel.apirestwithmysql.model.Course;

/**
 * Class to make the link between the 
 * application and the database 
 * 
 * @author ABDEL-NASSER BEN ALI
 *
 */
public interface CourseRepository extends JpaRepository<Course, Integer> {

}

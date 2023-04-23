package com.dabel.apirestwithmysql.config;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dabel.apirestwithmysql.model.Course;
import com.dabel.apirestwithmysql.repository.CourseRepository;

/**
 *  Sample class to initialize some data in database
 *  
 * @author ABDEL-NASSER BEN ALI
 *
 */
@Configuration
public class LoadData {

	@Bean
	CommandLineRunner initDatabase(CourseRepository repository) {
		
		return args -> {
			
			repository.save(new Course("Découvrez Spring Boot","Le lorem ipsum est, en imprimerie.", "Développement", "facile"));
			repository.save(new Course("Trouvez votre niche","Le lorem ipsum est, en imprimerie.", "Marketing", "moyen"));
			repository.save(new Course("MySQL et les SGBDR","Le lorem ipsum est, en imprimerie.", "Data", "Difficile"));
			repository.save(new Course("Excel pour débutant","Le lorem ipsum est, en imprimerie.", "Bureautique", "facile"));
			
			LoggerFactory.getLogger(getClass()).info("Preloadint data successufly executed");
		};
	}
}

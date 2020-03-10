package com.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EntityScan(basePackages = {"com.student.model"})
public class StudentApplication extends SpringBootServletInitializer {
	
	
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
}

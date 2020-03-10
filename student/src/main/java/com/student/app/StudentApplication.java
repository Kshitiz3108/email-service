package com.student.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EntityScan(basePackages = {"com.student.model"})
public class StudentApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
}

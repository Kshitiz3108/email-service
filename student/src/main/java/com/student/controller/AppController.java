package com.student.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.*;
import com.student.services.student_service;
import com.student.services.user_service;

@CrossOrigin(origins="*")
@RestController 
@RequestMapping("/")
public class AppController {
	
	@Autowired
	private student_service studentservice;
	
	@Autowired
	private user_service userservice;
	
	
	
	@PostMapping("user/register-user")
	public String registerUser(@RequestBody User user){
		return userservice.createUser(user);
	}
	
	@PostMapping("user/login-user")
	public POJO LoginUser(@RequestBody User user){
		 return userservice.LoginUser(user);
	}
	
	@GetMapping("user/login-user/{u}/{p}")
	public User loggedUser(@PathVariable("u") String uname,@PathVariable("p") String pwd){
		return userservice.logged(uname, pwd);
	}
	
	@PostMapping("user/edit-user")
	public void editUser(@RequestBody User user){
		userservice.editUser(user);
	}
	@PostMapping("user/change-password")
	public POJO changePassword(@RequestBody User user){
		return userservice.changePassword(user);
	}
	
	@GetMapping("user/user-list")
	public List<User> allUser() {
		return userservice.getUsers();       
    }
	
	@PostMapping("user/verify-user/{user_id}")
	public User verifyUser(@PathVariable("user_id") int user_id){
		return userservice.verifyUser(user_id);
	}
	
	@PostMapping("students/save-student")
	public void saveStudent(@RequestBody Student student){
		studentservice.saveStudent(student);
	}
	
	@GetMapping("students/student-list")
	public List<Student> allstudents() {
		return studentservice.getStudents();       
   }
	
	@DeleteMapping("students/delete-student/{student_id}")
	public void deleteStudent(@PathVariable("student_id") int student_id)  {  
      studentservice.deleteStudent(student_id); 
    } 
	
	@GetMapping("students/student-search/{student_id}")
	public Student allstudentByID(@PathVariable("student_id") int student_id)  {
		return studentservice.getStudentByID(student_id);      
   }
	
	@PutMapping("students/update-student/{student_id}")  
    public Student updateStudent(@RequestBody Student student,@PathVariable("student_id") int student_id)  {
		return studentservice.updateStudent(student_id,student);  
    }  
	
}

package com.student.services;

import java.util.List;

import com.student.model.Student;

public interface student_service {
	public Student saveStudent(Student student);  
    public List<Student> getStudents();  
    public void deleteStudent(int id) ;  
    public Student getStudentByID(int id) ;  
    public Student updateStudent(int id,Student s) ;
}

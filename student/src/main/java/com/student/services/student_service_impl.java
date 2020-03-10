package com.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.model.Student;
import com.student.repository.Student_repo;

@Service
@Transactional
public class student_service_impl implements student_service {

	@Autowired
	private Student_repo studentdao;
	
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentdao.save(student);
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return this.studentdao.findAll();
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		this.studentdao.deleteById(id);
		
	}

	@Override
	public Student getStudentByID(int id) {
		// TODO Auto-generated method stub
		return studentdao.findById(id).get();
	}

	@Override
	public Student updateStudent(int id, Student st) {
		// TODO Auto-generated method stub
		Student s=this.studentdao.findById(id).get();
		
//		Student s=studentDb.get();
		//Student s=new Student();
		//s.setStudent_id(st.getStudent_id());
		s.setStudent_name(st.getStudent_name());
		s.setStudent_email(st.getStudent_email());
		s.setStudent_branch(st.getStudent_branch());
		studentdao.save(s);
		System.out.println(s.getStudent_name());
		return st;
	}
	
}

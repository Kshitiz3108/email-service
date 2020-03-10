package com.student.services;

import java.util.List;

import com.student.model.POJO;
import com.student.model.User;

public interface user_service {
	public String createUser(User user);
	public POJO LoginUser(User user);
	public User logged(String username,String passwords);
	public User editUser(User user);
	public List<User> getUsers();
	public POJO changePassword(User user);
	public User verifyUser(int id);
}

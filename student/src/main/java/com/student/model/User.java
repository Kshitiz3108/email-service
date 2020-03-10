package com.student.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@Table(name="Users")
@EnableAutoConfiguration
public class User {
	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id;
	
	@Column(name="USER_NAME",unique=true)
	private String user_name;
	
	@Column(name="USER_PASSWORD")
	private String user_password;
	
	@Column(name="USER_WORD")
	private String user_word;
	
	@Column(name="USER_DOB")
	private Date user_dob;
	
	@Column(name="USER_NEW_PASSWORD")
	private String user_new_password;
	
	@Column(name="USER_ROLE")
	private String user_role;
	
	@Column(name="USER_VERIFICATION")
	private String user_verification;
	
	
	public String getUser_verification() {
		return user_verification;
	}
	public void setUser_verification(String user_verification) {
		this.user_verification = user_verification;
	}
	public String getUser_new_password() {
		return user_new_password;
	}
	public void setUser_new_password(String user_new_password) {
		this.user_new_password = user_new_password;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_word() {
		return user_word;
	}
	public void setUser_word(String user_word) {
		this.user_word = user_word;
	}
	public Date getUser_dob() {
		return user_dob;
	}
	public void setUser_dob(Date user_dob) {
		this.user_dob = user_dob;
	}
}

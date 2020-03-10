package com.student.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.model.POJO;
import com.student.model.User;
import com.student.repository.*;

@Service
@Transactional
public class user_service_impl implements user_service {

	@Autowired
	private user_repo user_repo;
	
	@PersistenceContext
	EntityManager entitymanager;
	
	@Override
	public String createUser(User user) {
		// TODO Auto-generated method stub
		user.setUser_verification("UNVERIFIED");
		String s="User needs to be verified";
		user_repo.save(user);
		return s;
	}

	@Override
	public POJO LoginUser(User user) {
		// TODO Auto-generated method stub
		POJO pojo=new POJO();
		if(user.getUser_name().equalsIgnoreCase("admin")&&user.getUser_password().equalsIgnoreCase("admin")) {
			pojo.setStatus("admin login");
			return pojo;
		}
		else {
			Query query=entitymanager.createNativeQuery("SELECT * FROM USERS WHERE USER_NAME=?", User.class);
			query.setParameter(1, user.getUser_name());
			int index=query.getResultList().size();
			if(index==0) {
				pojo.setStatus("No User Found");
				return pojo;
			}
			else {
				User u=(User)query.getResultList().get(0);
				String p=user.getUser_password();
				if(u.getUser_password().equals(p)) {
					if(u.getUser_verification().equalsIgnoreCase("VERIFIED")) {
						pojo.setUser(u);
						pojo.setStatus("Welcome");
						return pojo;
					}
					else {
						pojo.setStatus("not verified");
						return pojo;
					}
				}
				else {
					pojo.setStatus("Password wrong");
					return pojo;
					
				}
			}
		}
	}

	@Override
	public User logged(String username, String passwords) {
		// TODO Auto-generated method stub
		Query query=entitymanager.createNativeQuery("SELECT * FROM USERS WHERE USER_NAME=? AND USER_PASSWORD=?",User.class);
		query.setParameter(1, username);
		query.setParameter(2, passwords);
		return (User)query.getResultList().get(0);
		
	}

	@Override
	public User editUser(User user) {
		// TODO Auto-generated method stub
		Query query=entitymanager.createNativeQuery("UPDATE USERS SET USER_WORD =?,USER_DOB =? WHERE USER_NAME=? AND USER_PASSWORD =?");
		query.setParameter(1, user.getUser_word());
		query.setParameter(2, user.getUser_dob());
		query.setParameter(3, user.getUser_name());
		query.setParameter(4, user.getUser_password());
		query.executeUpdate();
		return user;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		Query q=entitymanager.createNativeQuery("SELECT * FROM USERS WHERE USER_VERIFICATION=?",User.class);
		q.setParameter(1, "UNVERIFIED");
		return q.getResultList();
	}

	@Override
	public POJO changePassword(User user) {
		// TODO Auto-generated method stub
		POJO p=new POJO();
		Query q=entitymanager.createNativeQuery("SELECT * FROM USERS WHERE USER_NAME=? AND USER_PASSWORD=?",User.class);
		q.setParameter(1, user.getUser_name());
		q.setParameter(2, user.getUser_password());
		int index=q.getResultList().size();
		if(index==0){
			p.setStatus("invalid password");
			return p;
		}
		else{
			Query query=entitymanager.createNativeQuery("UPDATE USERS SET USER_PASSWORD=? WHERE USER_NAME=? AND USER_PASSWORD=?");
			query.setParameter(1, user.getUser_new_password());
			query.setParameter(2, user.getUser_name());
			query.setParameter(3, user.getUser_password());
			query.executeUpdate();
			p.setStatus("valid password");
			p.setUser(user);
			return p;
		}
	}

	@Override
	public User verifyUser(int id) {
		// TODO Auto-generated method stub
		User user=user_repo.findById(id).get();
		user.setUser_verification("VERIFIED");
		return user;
	}
	
}

package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.User;

public interface user_repo extends JpaRepository<User, Integer> {

}

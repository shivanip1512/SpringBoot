package com.shivani.springboot.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shivani.springboot.jpa.entity.User;

public interface UserRepo extends CrudRepository<User, Integer> {

	List<User> findByName(String name);
	
	@Query("select u from User u")
	List<User> getAllUsers();
	
}

package com.shivani.springboot.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.shivani.springboot.jpa.entity.User;

public interface UserRepo extends CrudRepository<User, Integer> {

	List<User> findByName(String name);
	
	@Query("select u from User u")
	List<User> getAllUsers();
	
	@Query("SELECT u from User u WHERE u.name= :n")
	List<User> getUserByName(@Param("n") String name);
	
	
	@Query(value = "select * from user", nativeQuery = true)
	List<User> getUsers();
	
}

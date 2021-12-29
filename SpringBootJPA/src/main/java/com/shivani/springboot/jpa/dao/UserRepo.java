package com.shivani.springboot.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.shivani.springboot.jpa.entity.User;

public interface UserRepo extends CrudRepository<User, Integer> {

}

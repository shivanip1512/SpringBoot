package com.shivani.springboot.restAPI.dao;

import org.springframework.data.repository.CrudRepository;

import com.shivani.springboot.restAPI.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

	Book findById(int id);
}

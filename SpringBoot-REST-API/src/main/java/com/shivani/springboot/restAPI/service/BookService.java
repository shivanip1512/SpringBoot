package com.shivani.springboot.restAPI.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shivani.springboot.restAPI.entity.Book;

@Service
public interface BookService {

	List<Book> getAllBooks();

	Book getBookById(int id);

	void createBook(Book book);

	Book deleteById(int id);

	void updateBook(Book book, int id);

}

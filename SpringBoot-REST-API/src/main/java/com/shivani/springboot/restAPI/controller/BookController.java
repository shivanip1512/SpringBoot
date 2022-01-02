package com.shivani.springboot.restAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shivani.springboot.restAPI.entity.Book;
import com.shivani.springboot.restAPI.service.BookService;

//@Controller
@RestController
public class BookController {

	@Autowired
	BookService service;

	// @RequestMapping(method = RequestMethod.GET, value = "/books")
	@GetMapping("/books")
	public List<Book> getBooks() {
		return this.service.getAllBooks();
	}

	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		return this.service.getBookById(id);
	}
}

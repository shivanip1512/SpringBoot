package com.shivani.springboot.restAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@PostMapping("/books")
	public Book createBook(@RequestBody Book book) {
		this.service.createBook(book);
		return book;
	}

	@DeleteMapping("/books/{id}")
	public Book deleteBook(@PathVariable("id") int id) {
		return this.service.deleteById(id);
	}

	@PutMapping("/books/{id}")
	public void updateBook(@RequestBody Book book, @PathVariable("id") int id) {
		this.service.updateBook(book, id);
	}
}

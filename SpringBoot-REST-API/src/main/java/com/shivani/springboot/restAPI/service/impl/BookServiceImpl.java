package com.shivani.springboot.restAPI.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.shivani.springboot.restAPI.entity.Book;
import com.shivani.springboot.restAPI.service.BookService;

@Component
public class BookServiceImpl implements BookService {

	List<Book> list = new ArrayList<>();

	{
		Book book = new Book(1, "Java Basics", "James G.", 850.79);
		Book book2 = new Book(2, "C++", "Yashwant K.", 500);
		Book book3 = new Book(3, "Python", "Yashwant K.", 650.20);
		list = List.of(book, book2, book3);
	}

	@Override
	public List<Book> getAllBooks() {
		return list;
	}

	@Override
	public Book getBookById(int id) {
		Book book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		return book;
	}

}

package com.shivani.springboot.restAPI.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
		list.add(book);
		list.add(book2);
		list.add(book3);
	}

	@Override
	public List<Book> getAllBooks() {
		return list;
	}

	@Override
	public Book getBookById(int id) {

		Book book = null;
		try {
			book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
		return book;
	}

	@Override
	public void createBook(Book book) {
		list.add(book);
	}

	@Override
	public Book deleteById(int id) {
		Book bookById = this.getBookById(id);
		// list.remove(bookById);
		try {
			list = list.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookById;
	}

	@Override
	public void updateBook(Book book, int id) {
		list = list.stream().map(b -> {
			if (b.getId() == id) {
				b.setAuthor(book.getAuthor());
				b.setTitle(book.getTitle());
				b.setPrice(book.getPrice());
			}
			return b;
		}).collect(Collectors.toList());
	}

}

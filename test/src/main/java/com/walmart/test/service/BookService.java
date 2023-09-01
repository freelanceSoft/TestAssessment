package com.walmart.test.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.walmart.test.model.Book;

public interface BookService {
	
	List<Book> getbooks();
	
	Book getBookByIsbn(Long isbn);
	
	void addBook(Book book);
	
	List<Book> getBookByAuthor(String author);
	
	List<Book> getBookPubDateAfter(Date date);

}

package com.walmart.test.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walmart.test.model.Book;
import com.walmart.test.repository.BookRepository;
import com.walmart.test.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Book> getbooks() {

		return bookRepository.findAll();

	}

	@Override
	public Book getBookByIsbn(Long isbn) {

		return bookRepository.findBookByIsbn(isbn);

	}

	@Override
	public void addBook(Book book) {

		Date today = new Date();
						
		if (book.getPublicationDate().after(today))
			throw new IllegalArgumentException("Publication date cannot be greater than the current day");

		bookRepository.save(book);

	}

	@Override
	public List<Book> getBookByAuthor(String author) {
		
		return bookRepository.findBookByIAuthor(author);
		
	}
	
	@Override
	public List<Book> getBookPubDateAfter(Date date) {
				
		return bookRepository.findBookPubDateAfter(date);
	
	}

}

package com.walmart.test.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.test.model.Book;
import com.walmart.test.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/api/book")
	@ResponseBody
	public List<Book> getAllBooks(){
		
		return bookService.getbooks();
		
	}
	
	@GetMapping("/api/book/isbn/{isbn}")
	@ResponseBody
	public Book getBookByIsbn(@PathVariable Long isbn){
		
		return bookService.getBookByIsbn(isbn);
		
	}
	
	@PostMapping("/api/book")
	@ResponseBody
	public void addBook(@RequestBody Book book) {
		
		bookService.addBook(book);
		
	}
	
	@GetMapping("/api/book/author/{author}")
	@ResponseBody
	public List<Book> getBookByIsbn(@PathVariable String author){
		
		return bookService.getBookByAuthor(author);
		
	}
	
	@GetMapping("/api/book/after-date")
	@ResponseBody
	public List<Book> getBooksByPubDateAfter(@RequestParam("date") 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		
		Date datePub = Date.from(date.atStartOfDay(defaultZoneId).toInstant());
				
		return bookService.getBookPubDateAfter(datePub);
		
	}

}

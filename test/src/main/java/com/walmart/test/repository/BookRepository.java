package com.walmart.test.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.walmart.test.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Query(value = "select isbn, title, author, publication_date from Book where isbn = :isbn", nativeQuery = true)
	Book findBookByIsbn(Long isbn);
	
	@Query(value = "select isbn, title, author, publication_date from Book where author = :author", nativeQuery = true)
	List<Book> findBookByIAuthor(String author);
	
	@Query(value = "select isbn, title, author, publication_date from Book where publication_date > TO_DATE(:date, 'YYYY-MM-DD')", nativeQuery = true)
	List<Book> findBookPubDateAfter(Date date);

}

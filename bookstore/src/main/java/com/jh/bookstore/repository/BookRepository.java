package com.jh.bookstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jh.bookstore.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	Page<Book> findByNameContaining(String searchKeyword, Pageable pageable);
}

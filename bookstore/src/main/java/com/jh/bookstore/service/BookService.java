package com.jh.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jh.bookstore.model.Book;
import com.jh.bookstore.repository.BookRepository;


@Service
public class BookService {
	
	@Autowired
	private BookRepository bRepo;
	
	public void save(Book b) {
		bRepo.save(b);
	}
	
	public Page<Book> getAllBook(Pageable pageable){
		return bRepo.findAll(pageable);
	}
	
	public Book getBookById(int id) {
		return bRepo.findById(id).get();
	}
	
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}

	public Page<Book> bookSearchList(String searchKeyword,Pageable pageable){
        return bRepo.findByNameContaining(searchKeyword,pageable);
    }
}

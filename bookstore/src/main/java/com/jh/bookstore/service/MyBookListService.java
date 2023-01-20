package com.jh.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jh.bookstore.model.MyBookList;
import com.jh.bookstore.repository.MyBookRepository;

@Service
public class MyBookListService {
	
	@Autowired
	private MyBookRepository mbRepo;
	
	public void saveMyBooks(MyBookList book) {
		mbRepo.save(book);
	}
	
	public Page<MyBookList> getAllMyBooks(Pageable pageable){
		return mbRepo.findAll(pageable);
	}
	
	public void deleteById(int id) {
		mbRepo.deleteById(id);
	}
}

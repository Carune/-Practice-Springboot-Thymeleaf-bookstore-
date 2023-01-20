package com.jh.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jh.bookstore.model.Book;
import com.jh.bookstore.model.MyBookList;
import com.jh.bookstore.service.BookService;
import com.jh.bookstore.service.MyBookListService;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService myBookService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public String getAllBook(Model model, @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable, String searchKeyword) {
		Page<Book> list = service.getAllBook(pageable);
		
		if (searchKeyword == null) {
            // 검색 단어가 없으면 기존 화면을 보여준다.
            list =service.getAllBook(pageable);
        } else {

            // 검색 단어가 들어오면 검색 단어에 맞게 나온다. 쿼리스트링으로 들어가는 키워드를 찾아냄
            list = service.bookSearchList(searchKeyword, pageable);
        }
		
		 //페이지블럭 처리
        //1을 더해주는 이유는 pageable은 0부터라 1을 처리하려면 1을 더해서 시작해주어야 한다.
		int nowPage = list.getPageable().getPageNumber() + 1;
		
        //-1값이 들어가는 것을 막기 위해서 max값으로 두 개의 값을 넣고 더 큰 값을 넣어주게 된다.
        int startPage =  Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage+4, list.getTotalPages());


        model.addAttribute("book", list);
        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

		return "bookList";
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/available_books";
	}
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList> list = myBookService.getAllMyBooks();

       model.addAttribute("book", list);

		return "myBooks";
	}
	
	@GetMapping("/mylist/{id}")
	public String getMyList(@PathVariable int id) {
		Book b = service.getBookById(id);
		MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		myBookService.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	
	@GetMapping("/editBook/{id}")
	public String editBook(@PathVariable int id, Model model) {
		Book b = service.getBookById(id);
		model.addAttribute("book", b);
		return "bookEdit";
	}
	
	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable int id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}
}

package com.ozguryazilim.presentation.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozguryazilim.data.entity.Book;
import com.ozguryazilim.data.repository.BookRepository;

@RestController
@RequestMapping("/rest/book")
public class BookResource {
	
	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping(value="/save")
	public String saveBook(@ModelAttribute("book") Book book) {
		bookRepository.save(book);
		return "{ \"status\":\"success\" }";
	}
	
}	

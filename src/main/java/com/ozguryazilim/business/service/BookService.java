package com.ozguryazilim.business.service;

import java.util.List;

import com.ozguryazilim.business.dto.BookDto;

public interface BookService {
	
	public void save(BookDto bookDto);
	
	public BookDto find(Long bookDtoId);
	
	public List<BookDto> list();
	
	public void delete(Long bookDtoId);
	
}

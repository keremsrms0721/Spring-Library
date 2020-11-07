package com.ozguryazilim.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.ozguryazilim.data.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	
}

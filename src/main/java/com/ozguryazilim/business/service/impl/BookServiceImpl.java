package com.ozguryazilim.business.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozguryazilim.business.dto.BookDto;
import com.ozguryazilim.business.service.BookService;
import com.ozguryazilim.data.entity.Book;
import com.ozguryazilim.data.entity.Publisher;
import com.ozguryazilim.data.entity.Writer;
import com.ozguryazilim.data.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	// BOOK ADD

	@Override
	public void save(BookDto bookDto) {
		Book book = new Book();
		toEntity(bookDto, book);
		bookRepository.save(book);
	}

	// BOOK FIND

	@Override
	public BookDto find(Long bookDtoId) {
		Book book = null;
		BookDto bookDto = new BookDto();
		if (bookDtoId == null || bookDtoId == 0) {
			return bookDto;
		}
		Optional<Book> optional = bookRepository.findById(bookDtoId);
		book = optional.get();
		toDto(book, bookDto);
		return bookDto;
	}

	// FILTERING LIST

	@Override
	public List<BookDto> list() {
		List<BookDto> bookDtoList = returnBookDtoList(bookRepository.findAll());
		return bookDtoList;
	}

	private List<BookDto> returnBookDtoList(Iterable<Book> books) {
		List<BookDto> bookDtoList = new ArrayList<>();
		for (Book book : books) {
			BookDto bookDto = new BookDto();
			toDto(book, bookDto);
			bookDtoList.add(bookDto);
		}
		return bookDtoList;
	}

	// DELETE BOOK

	@Override
	public void delete(Long bookDtoId) {
		if (bookDtoId != null && bookDtoId != 0) {
			bookRepository.deleteById(bookDtoId);
		}
	}

	// CONVERT FROM BOOKDTO TO ENTITY

	private void toEntity(BookDto bookDto, Book book) {
		// publisher and writer objects
		Publisher publisher = new Publisher();
		Writer writer = new Writer();
		publisher.setPublisherId(bookDto.getPublisherId());
		writer.setWriterId(bookDto.getWriterId());
		// converting process
		book.setBookId(bookDto.getBookId());
		book.setBookName(bookDto.getBookName());
		book.setDescription(bookDto.getDescription());
		book.setIsbn(bookDto.getIsbn());
		book.setSeriesName(bookDto.getSeriesName());
		book.setPublisher(publisher);
		book.setWriter(writer);
	}

	// CONVERT FROM ENTITY TO BOOKDTO
	private void toDto(Book book, BookDto bookDto) {
		bookDto.setBookId(book.getBookId());
		bookDto.setBookName(book.getBookName());
		bookDto.setDescription(book.getDescription());
		bookDto.setIsbn(book.getIsbn());
		bookDto.setPublisherId(book.getPublisher().getPublisherId());
		bookDto.setPublisherName(book.getPublisher().getPublisherName());
		bookDto.setPublisherDescription(book.getPublisher().getPublisherDescription());
		bookDto.setWriterSurname(book.getWriter().getWriterSurname());
		bookDto.setWriterDescription(book.getWriter().getWriterDescription());
		bookDto.setWriterId(book.getWriter().getWriterId());
		bookDto.setWriterName(book.getWriter().getWriterName());
		bookDto.setSeriesName(book.getSeriesName());
	}

}

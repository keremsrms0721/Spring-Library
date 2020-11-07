package com.ozguryazilim.presentation.mvc;

import java.util.InputMismatchException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ozguryazilim.business.dto.BookDto;
import com.ozguryazilim.business.dto.PublisherDto;
import com.ozguryazilim.business.dto.WriterDto;
import com.ozguryazilim.business.service.BookService;
import com.ozguryazilim.business.service.PublisherService;
import com.ozguryazilim.business.service.WriterService;

@Controller
@RequestMapping("/admin/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private PublisherService publisherService;

	@Autowired
	private WriterService writerService;
	
	// ADDING BOOK
	
	@GetMapping("/add")
	public String addBook(Model model) {
		try {
			BookDto bookDto = new BookDto();
			// WRITERS
			List<WriterDto> writers = writerService.list();
			// PUBLISHERS
			List<PublisherDto> publishers = publisherService.list();
			model.addAttribute("writers", writers);
			model.addAttribute("publishers", publishers);
			model.addAttribute("book", bookDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/book/AddBook";
	}

	// DELETION BOOK
	
	@GetMapping("/delete/{id}")
	public String deleteBook(Model model,RedirectAttributes redirectAttributes,@PathVariable("id") Long id) {
		try {
			BookDto dto = bookService.find(id);
			if(id == null || id == 0) {
				throw new IllegalArgumentException();
			}
			redirectAttributes.addFlashAttribute("alertClass", "alert-primary");
			redirectAttributes.addFlashAttribute("message", "Book deleted successfully.");
			if(dto != null) bookService.delete(id);
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("message", "Book did not delete successfully.");
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
		}
		return "redirect:/admin/book/list";
	}
	
	// LISTING BOOKS

	@GetMapping("/list")
	public String getBooks(Model model) {
		try {
			List<BookDto> books = bookService.list();
			model.addAttribute("books", books);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "admin/book/GetBooks";
	}
	
	// EDITING BOOK
	
	@GetMapping("/edit/{id}")
	public String editBook(Model model,RedirectAttributes redirectAttributes,@PathVariable("id") Long id) {
		try {
			BookDto foundBookDto = bookService.find(id);
			if(id == null || id == 0) {
				throw new IllegalArgumentException();
			}
			// WRITERS
			List<WriterDto> writers = writerService.list();
			// PUBLISHERS
			List<PublisherDto> publishers = publisherService.list();
			model.addAttribute("book", foundBookDto);
			model.addAttribute("writers", writers);
			model.addAttribute("publishers", publishers);
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			redirectAttributes.addFlashAttribute("message", "No such book.");
		}
		return "admin/book/EditBook";
	}
	
	@PostMapping("/edit/{id}")
	public String editBook(Model model,RedirectAttributes redirectAttributes, BookDto bookDto,BindingResult result,@PathVariable("id") Long id) {
		try {
			if (result.hasErrors()) {
				throw new InputMismatchException();
			}
			redirectAttributes.addFlashAttribute("alertClass", "alert-success");
			redirectAttributes.addFlashAttribute("message", "Book edited successfully.");
			bookDto.setBookId(id);
			bookService.save(bookDto);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			redirectAttributes.addFlashAttribute("message", "Book did not edit successfully.");
		}
		return "redirect:/admin/book/list";
	}
	
}

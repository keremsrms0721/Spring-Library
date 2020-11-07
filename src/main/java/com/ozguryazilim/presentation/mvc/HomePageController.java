package com.ozguryazilim.presentation.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ozguryazilim.business.service.BookService;
import com.ozguryazilim.data.entity.Users;

@Controller
public class HomePageController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String getUser(Model model) {
		model.addAttribute("books", bookService.list());
		try {
			Users user = new Users();
			model.addAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "HomePage.html";
	}

}

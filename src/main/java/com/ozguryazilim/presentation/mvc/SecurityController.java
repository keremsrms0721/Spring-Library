package com.ozguryazilim.presentation.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ozguryazilim.business.service.BookService;

@Controller
public class SecurityController {

	@Autowired
	private BookService bookService;

	@GetMapping("/frontend/login")
	public String getLogin(Model model, @RequestParam(name = "error", required = false) String error,RedirectAttributes redirectAttributes) {
		try {
			if (error != null) {
				throw new Exception();
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "Username or password is invalid");
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/";
		}
		return "redirect:/frontend/home";
	}

	@GetMapping("/frontend/logout")
	public String getLogout(Model model, HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!authentication.getName().equals("anonymousUser")) {
				new SecurityContextLogoutHandler().logout(request, response, authentication);
			} else {
				return "redirect:/";
			}
			redirectAttributes.addFlashAttribute("message", "You have been logged out successfully");
			redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

	@GetMapping("/frontend/home")
	public String getLogoutTest(Model model) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			model.addAttribute("books", bookService.list());
			model.addAttribute("authenticationUsername", authentication.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "frontend/Home";
	}
}
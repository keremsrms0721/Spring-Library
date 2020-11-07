package com.ozguryazilim.presentation.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ozguryazilim.business.dto.UsersDto;
import com.ozguryazilim.business.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/admin/users")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private PasswordEncoder encoder;

	// ADDING USER

	@GetMapping("/add")
	public String addUser(Model model) {
		try {
			UsersDto userDto = new UsersDto();
			model.addAttribute("users", userDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/users/AddUser";
	}

	@PostMapping("/add")
	public String addUser(Model model, RedirectAttributes redirectAttributes, UsersDto userDto,
			@PathVariable(value = "id", required = false) Long id, BindingResult result) {
		try {
			if (result.hasErrors()) {
				throw new IllegalAccessException();
			}
			if (id != null && id != 0)
				userDto.setUserId(id);
			redirectAttributes.addFlashAttribute("alertClass", "alert-success");
			redirectAttributes.addFlashAttribute("message", "User added successfully");
			userDto.setUserPassword(encoder.encode(userDto.getUserPassword()));
			userService.save(userDto);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			redirectAttributes.addFlashAttribute("message", "User did not add.");
		}
		return "redirect:/admin/users/list";
	}

	// DELETION USER

	@GetMapping("/delete/{id}")
	public String deleteUser(Model model, RedirectAttributes redirectAttributes, @PathVariable("id") Long id) {
		try {
			UsersDto userDto = userService.find(id);
			if (id == null || id == 0) {
				throw new IllegalArgumentException();
			}
			if (userDto != null)
				userService.delete(id);
			redirectAttributes.addFlashAttribute("alertClass", "alert-primary");
			redirectAttributes.addFlashAttribute("message", "User deleted successfully");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "Publisher did not delete successfully.");
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");

		}
		return "redirect:/admin/users/list";
	}
	// LISTING USERS

	@GetMapping("/list")
	public String getUsers(Model model) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			List<UsersDto> users = userService.list();
			model.addAttribute("users", users);
			model.addAttribute("currentUsername", authentication.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/users/GetUsers";
	}

	// EDITING USER

	@GetMapping("/edit/{id}")
	public String editUser(Model model, RedirectAttributes redirectAttributes, @PathVariable("id") Long id) {
		try {
			if (id == null || id == 0) {
				return "redirect:/admin/users/list";
			}
			UsersDto foundUserDto = userService.find(id);
			model.addAttribute("users", foundUserDto);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			redirectAttributes.addFlashAttribute("message", "No such user.");
		}
		return "admin/users/EditUser";
	}

	@PostMapping("/edit/{id}")
	public String editPublisher(Model model, RedirectAttributes redirectAttributes, UsersDto userDto,
			BindingResult result, @PathVariable("id") Long id) {
		try {
			if (result.hasErrors()) {
				throw new IllegalAccessException();
			}
			redirectAttributes.addFlashAttribute("alertClass", "alert-success");
			redirectAttributes.addFlashAttribute("message", "User edited successfully");
			userDto.setUserId(id);
			userService.save(userDto);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			redirectAttributes.addFlashAttribute("message", "User did not edit successfully.");

		}
		return "redirect:/admin/users/list";
	}

}

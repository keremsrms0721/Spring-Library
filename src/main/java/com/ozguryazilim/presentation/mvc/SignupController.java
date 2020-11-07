package com.ozguryazilim.presentation.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ozguryazilim.data.entity.Users;
import com.ozguryazilim.data.repository.UserRepository;

@Controller
public class SignupController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	
	@PostMapping("/frontend/signup")
	public String getUser(Users user,BindingResult result,Model model,RedirectAttributes redirectAttributes) {
		try {
			if (result.hasErrors()) {
				result.addError(new ObjectError("user", "ERROR OCCURED !!"));
				return "redirect:/";
			}
			Users users = userRepository.findByUserName(user.getUserName());
			if(users == null) {
				user.setUserRole("USER");
				user.setUserPassword(encoder.encode(user.getUserPassword()));
				userRepository.save(user);
			}else {
				redirectAttributes.addFlashAttribute("message", "There is such username please enter different username");
				redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
				return "redirect:/";
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "Error occured.Please try again");
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/";
		}
		redirectAttributes.addFlashAttribute("message", "You have successfully signed up.");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return "redirect:/";
	}

}

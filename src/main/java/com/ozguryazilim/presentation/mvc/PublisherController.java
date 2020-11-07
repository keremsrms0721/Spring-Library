package com.ozguryazilim.presentation.mvc;

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

import com.ozguryazilim.business.dto.PublisherDto;
import com.ozguryazilim.business.service.PublisherService;

@Controller
@RequestMapping("/admin/publisher")
public class PublisherController {

	@Autowired
	private PublisherService publisherService;

	// ADDING PUBLISHER

	@GetMapping("/add")
	public String addPublisher(Model model) {
		try {
			PublisherDto publisherDto = new PublisherDto();
			model.addAttribute("publisher", publisherDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/publisher/AddPublisher";
	}

	// DELETION PUBLISHER

	@GetMapping("/delete/{id}")
	public String deletePublisher(Model model, RedirectAttributes redirectAttributes, @PathVariable("id") Long id) {
		try {
			PublisherDto publisherDto = publisherService.find(id);
			if (id == null || id == 0) {
				throw new IllegalArgumentException();
			}
			if (publisherDto != null)
				publisherService.delete(id);
			redirectAttributes.addFlashAttribute("alertClass", "alert-primary");
			redirectAttributes.addFlashAttribute("message", "Publisher deleted successfully");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "Publisher did not delete successfully.");
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
		}
		return "redirect:/admin/publisher/list";
	}

	// LISTING PUBLISHERS

	@GetMapping("/list")
	public String getPublishers(Model model) {
		try {
			List<PublisherDto> publishers = publisherService.list();
			model.addAttribute("publishers", publishers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/publisher/GetPublishers";
	}

	// EDITING PUBLISHER

	@GetMapping("/edit/{id}")
	public String editPublisher(Model model, RedirectAttributes redirectAttributes, @PathVariable("id") Long id) {
		try {
			if (id == null || id == 0) {
				throw new IllegalArgumentException();
			}
			PublisherDto foundPublisherDto = publisherService.find(id);
			model.addAttribute("publisher", foundPublisherDto);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			redirectAttributes.addFlashAttribute("message", "No such publisher.");
		}
		return "admin/publisher/EditPublisher";
	}

	@PostMapping("/edit/{id}")
	public String editPublisher(Model model, RedirectAttributes redirectAttributes, PublisherDto publisherDto,
			BindingResult result, @PathVariable("id") Long id) {
		try {
			if (result.hasErrors()) {
				throw new IllegalAccessException();
			}
			redirectAttributes.addFlashAttribute("alertClass", "alert-success");
			redirectAttributes.addFlashAttribute("message", "Publisher edited successfully");
			publisherDto.setPublisherId(id);
			publisherService.save(publisherDto);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			redirectAttributes.addFlashAttribute("message", "Publisher did not edit successfully.");
		}
		return "redirect:/admin/publisher/list";
	}
}

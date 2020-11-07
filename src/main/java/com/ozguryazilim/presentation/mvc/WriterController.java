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

import com.ozguryazilim.business.dto.WriterDto;
import com.ozguryazilim.business.service.WriterService;

@Controller
@RequestMapping("/admin/writer")
public class WriterController {

	@Autowired
	private WriterService writerService;

	// ADDING WRITER

	@GetMapping("/add")
	public String addWriter(Model model) {
		try {
			WriterDto writerDto = new WriterDto();
			model.addAttribute("writer", writerDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/writer/AddWriter";
	}

	// DELETION WRITER

	@GetMapping("/delete/{id}")
	public String deleteWriter(Model model, RedirectAttributes redirectAttributes, @PathVariable("id") Long id) {
		try {
			WriterDto writerDto = writerService.find(id);
			if (id == null || id == 0) {
				throw new IllegalArgumentException();
			}
			if (writerDto != null)
				writerService.delete(id);
			redirectAttributes.addFlashAttribute("alertClass", "alert-primary");
			redirectAttributes.addFlashAttribute("message", "Writer deleted successfully");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "Writer did not delete successfully.");
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
		}
		return "redirect:/admin/writer/list";
	}

	// LISTING WRITERS

	@GetMapping("/list")
	public String getWriters(Model model) {
		try {
			List<WriterDto> writers = writerService.list();
			model.addAttribute("writers", writers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/writer/GetWriters";
	}

	// EDITING PUBLISHER

	@GetMapping("/edit/{id}")
	public String editPublisher(Model model, RedirectAttributes redirectAttributes, @PathVariable("id") Long id) {
		try {
			if (id == null || id == 0) {
				throw new IllegalArgumentException();
			}
			WriterDto foundWriterDto = writerService.find(id);
			model.addAttribute("writer", foundWriterDto);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			redirectAttributes.addFlashAttribute("message", "No such writer.");
		}
		return "admin/writer/EditWriter";
	}

	@PostMapping("/edit/{id}")
	public String editPublisher(Model model, RedirectAttributes redirectAttributes, WriterDto writerDto,
			BindingResult result, @PathVariable("id") Long id) {
		try {
			if (result.hasErrors()) {
				throw new IllegalAccessException();
			}
			redirectAttributes.addFlashAttribute("alertClass", "alert-success");
			redirectAttributes.addFlashAttribute("message", "Writer edited successfully");
			writerDto.setWriterId(id);
			writerService.save(writerDto);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			redirectAttributes.addFlashAttribute("message", "Writer did not edit successfully.");
		}
		return "redirect:/admin/writer/list";
	}
}

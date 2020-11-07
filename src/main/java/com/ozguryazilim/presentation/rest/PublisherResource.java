package com.ozguryazilim.presentation.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozguryazilim.business.dto.PublisherDto;
import com.ozguryazilim.business.service.PublisherService;

@RestController
@RequestMapping("/rest/publisher")
public class PublisherResource {
	
	@Autowired
	private PublisherService publisherService;
	
	@PostMapping(value="/save")
	public String savePublisher(@ModelAttribute("publisher") PublisherDto publisher) {
		publisherService.save(publisher);
		return "{ \"status\":\"success\" }";
	}
	
}	



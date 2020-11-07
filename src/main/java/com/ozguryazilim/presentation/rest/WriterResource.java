package com.ozguryazilim.presentation.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozguryazilim.business.dto.WriterDto;
import com.ozguryazilim.business.service.WriterService;

@RestController
@RequestMapping("/rest/writer")
public class WriterResource {
	
	@Autowired
	private WriterService writerService;
	
	@PostMapping(value="/save")
	public String saveWriter(@ModelAttribute("writer") WriterDto writerDto) {
		writerService.save(writerDto);
		return "{ \"status\":\"success\" }";
	}
	
}	



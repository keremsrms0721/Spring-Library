package com.ozguryazilim.business.service;

import java.util.List;

import com.ozguryazilim.business.dto.PublisherDto;

public interface PublisherService {
	
	public void save(PublisherDto publisherDto);
	
	public PublisherDto find(Long publisherDtoId);
	
	public List<PublisherDto> list();
	
	public void delete(Long publisherDtoId);
	
}

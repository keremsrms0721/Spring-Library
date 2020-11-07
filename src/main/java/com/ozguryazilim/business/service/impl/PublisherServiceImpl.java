package com.ozguryazilim.business.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.ozguryazilim.business.dto.PublisherDto;
import com.ozguryazilim.business.service.PublisherService;
import com.ozguryazilim.data.entity.Publisher;
import com.ozguryazilim.data.repository.PublisherRepository;

@Service
public class PublisherServiceImpl implements PublisherService{
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	// SAVING PUBLISHER
	
	@Override
	public void save(PublisherDto publisherDto) {
		Publisher publisher = new Publisher();
		toEntity(publisherDto, publisher);
		publisherRepository.save(publisher);
	}
	
	// FIND PUBLISHER
	
	@Override
	public PublisherDto find(Long publisherDtoId) {
		Publisher publisher = null;
		PublisherDto publisherDto = new PublisherDto();
		if(publisherDtoId == null || publisherDtoId == 0) {
			return publisherDto;
		}
		Optional<Publisher> optional = publisherRepository.findById(publisherDtoId); 
		publisher = optional.get();
		toDto(publisher, publisherDto);
		return publisherDto;
	}
	
	// LISTING PUBLISHERS
	
	@Override
	public List<PublisherDto> list() {
		List<PublisherDto> publisherDtoList = new ArrayList<>();
		Iterable<Publisher> publishers = publisherRepository.findAll();
		for(Publisher publisher : publishers) {
			PublisherDto publisherDto = new PublisherDto();
			toDto(publisher, publisherDto);
			publisherDtoList.add(publisherDto);
		}
		return publisherDtoList;
	}
	
	
	// DELETION PUBLISHER
	
	@Override
	@Secured("ROLE_ADMIN")
	public void delete(Long publisherDtoId) {
		if(publisherDtoId != null && publisherDtoId != 0) {
			publisherRepository.deleteById(publisherDtoId);
		}
	}
	
	
	
	// CONVERT FROM Publisher_dto TO ENTITY
	private void toEntity(PublisherDto publisherDto, Publisher publisher) {
		publisher.setPublisherId(publisherDto.getPublisherId());
		publisher.setPublisherName(publisherDto.getPublisherName());
		publisher.setPublisherDescription(publisherDto.getPublisherDescription());
		publisher.setList(publisherDto.getList());
	}

	
	// CONVERT FROM ENTITY TO PUBLISHER_DTO
	private void toDto(Publisher publisher,PublisherDto publisherDto) {
		publisherDto.setPublisherId(publisher.getPublisherId());
		publisherDto.setPublisherName(publisher.getPublisherName());
		publisherDto.setPublisherDescription(publisher.getPublisherDescription());
		publisherDto.setList(publisher.getList());
	}

	

}

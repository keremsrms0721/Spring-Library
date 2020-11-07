package com.ozguryazilim.business.service;

import java.util.List;

import com.ozguryazilim.business.dto.WriterDto;

public interface WriterService {
	
	public void save(WriterDto writerDto);
	
	public WriterDto find(Long writerDtoId);
	
	public List<WriterDto> list();
	
	public void delete(Long writerDtoId);
	
	
}

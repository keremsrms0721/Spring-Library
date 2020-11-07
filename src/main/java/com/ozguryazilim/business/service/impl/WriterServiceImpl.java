package com.ozguryazilim.business.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozguryazilim.business.dto.WriterDto;
import com.ozguryazilim.business.service.WriterService;
import com.ozguryazilim.data.entity.Writer;
import com.ozguryazilim.data.repository.WriterRepository;

@Service
public class WriterServiceImpl implements WriterService{
	
	@Autowired
	private WriterRepository writerRepository;
	
	@Override
	public void save(WriterDto writerDto) {
		Writer writer = new Writer();
		toEntity(writerDto, writer);
		writerRepository.save(writer);
	}

	@Override
	public WriterDto find(Long writerDtoId) {
		Writer writer = null;
		WriterDto writerDto = new WriterDto();
		if(writerDtoId == null || writerDtoId == 0) {
			return writerDto;
		}
		Optional<Writer> optional = writerRepository.findById(writerDtoId); 
		writer = optional.get();
		toDto(writer, writerDto);
		return writerDto;
	}

	@Override
	public List<WriterDto> list() {
		List<WriterDto> writerDtoList = new ArrayList<>();
		Iterable<Writer> writers = writerRepository.findAll();
		for(Writer writer : writers) {
			WriterDto writerDto = new WriterDto();
			toDto(writer, writerDto);
			writerDtoList.add(writerDto);
		}
		return writerDtoList;
	}
	
	
	@Override
	public void delete(Long writerDtoId) {
		if(writerDtoId != null && writerDtoId != 0) {
			writerRepository.deleteById(writerDtoId);
		}
	}
	
	
	
	// CONVERT FROM BOOKDTO TO ENTITY
	private void toEntity(WriterDto writerDto, Writer writer) {
		writer.setWriterId(writerDto.getWriterId());
		writer.setWriterName(writerDto.getWriterName());
		writer.setWriterDescription(writerDto.getWriterDescription());
		writer.setWriterSurname(writerDto.getWriterSurname());
		writer.setList(writerDto.getList());
	}

	
	// CONVERT FROM ENTITY TO BOOKDTO
	private void toDto(Writer writer,WriterDto writerDto) {
		writerDto.setWriterId(writer.getWriterId());
		writerDto.setWriterName(writer.getWriterName());
		writerDto.setWriterDescription(writer.getWriterDescription());
		writerDto.setWriterSurname(writer.getWriterSurname());
		writerDto.setList(writer.getList());
	}

}

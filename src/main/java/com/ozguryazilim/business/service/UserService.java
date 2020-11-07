package com.ozguryazilim.business.service;

import java.util.List;

import com.ozguryazilim.business.dto.UsersDto;

public interface UserService {

	public void save(UsersDto usersDto);
	
	public UsersDto find(Long usersDtoId);
	
	public List<UsersDto> list();

	
	public void delete(Long usersDtoId);
	
}

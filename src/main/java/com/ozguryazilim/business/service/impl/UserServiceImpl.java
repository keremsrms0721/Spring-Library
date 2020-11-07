package com.ozguryazilim.business.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozguryazilim.business.dto.UsersDto;
import com.ozguryazilim.business.service.UserService;
import com.ozguryazilim.data.entity.Users;
import com.ozguryazilim.data.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	// USER SAVING
	
	@Override
	public void save(UsersDto usersDto) {
		Users users = new Users();
		toEntity(usersDto, users);
		userRepository.save(users);
	}
	
	// USER FINDING
	
	@Override
	public UsersDto find(Long usersDtoId) {
		Users users = null;
		UsersDto usersDto = new UsersDto();
		if(usersDtoId == 0 || usersDtoId == null) {
			return usersDto;
		}
		Optional<Users> optional = userRepository.findById(usersDtoId);
		users = optional.get();
		toDto(users,usersDto);
		return usersDto;
	}
	
	// LISTING USERS
	
	@Override
	public List<UsersDto> list() {
		List<UsersDto> usersDtoList = new ArrayList<>();
		Iterable<Users> allUsers = userRepository.findAll();
		for(Users users : allUsers) {
			UsersDto userDto = new UsersDto();
			toDto(users,userDto);
			usersDtoList.add(userDto);
		}
		return usersDtoList;
	}
	
	// DELETE USER
	
	@Override
	public void delete(Long userDtoId) {
		userRepository.deleteById(userDtoId);
	}
	

	// CONVERT FROM Users_dto TO ENTITY
	private void toEntity(UsersDto usersDto, Users users) {
		users.setUserId(usersDto.getUserId());
		users.setUserName(usersDto.getUserName());
		users.setUserPassword(usersDto.getUserPassword());
		users.setUserRole(usersDto.getUserRole());
	}

	
	// CONVERT FROM ENTITY TO users_DTO
	private void toDto(Users users,UsersDto usersDto) {
		usersDto.setUserId(users.getUserId());
		usersDto.setUserName(users.getUserName());
		usersDto.setUserPassword(users.getUserPassword());
		usersDto.setUserRole(users.getUserRole());
	}
	
	

}

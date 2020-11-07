package com.ozguryazilim.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ozguryazilim.data.entity.Users;
import com.ozguryazilim.data.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Users user = userRepository.findByUserName(username);
			String password = user.getUserPassword();
			String role = user.getUserRole();
			return User.withUsername(username).password(password).roles(role).build();
		} catch (Exception e) {
			throw new UsernameNotFoundException("Username not found");
		}
	}

}

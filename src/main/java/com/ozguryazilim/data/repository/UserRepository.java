package com.ozguryazilim.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ozguryazilim.data.entity.Users;

public interface UserRepository extends CrudRepository<Users, Long>{
	
	@Query("select u from Users u where u.userName = :username")
	public Users findByUserName(@Param("username") String username);
	
	
}

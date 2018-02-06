package com.skcc.teamcrystal.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skcc.teamcrystal.backend.entity.User;;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	User findByUserName(String userName);
	User findById(Long userId);
	
}
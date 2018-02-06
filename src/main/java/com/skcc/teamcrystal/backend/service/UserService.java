package com.skcc.teamcrystal.backend.service;

import com.skcc.teamcrystal.backend.entity.User;

public interface UserService {

	User findById(Long userId);

	User findByEmail(String email);

	User findByUsername(String username);

	String createUser(String username, String email, String password);

	String login(String email, String password);

}

package com.skcc.teamcrystal.backend.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcc.teamcrystal.backend.entity.User;
import com.skcc.teamcrystal.backend.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByEmail(String email) {
		User user = userRepository.findByEmail(email);
		return user;
	}

	@Override
	public User findByUsername(String username) {
		User user = userRepository.findByUserName(username);
		return user;
	}

	@Override
	public String createUser(String userName, String email, String password) {
	
		if (findByEmail(email) == null && findByUsername(userName) == null) {
			User user = new User();
			user.setEmail(email);
			user.setUserName(userName);
			user.setPassword(password);

			userRepository.saveAndFlush(user);
			logger.info("User Created! User ID: " + user.getId());
			return "{\"result\": \"SUCCESS\", \"USER_ID\":\"" + user.getId() + "\"}";
		} else if (findByEmail(email) != null && findByUsername(userName) == null) {
			return "{\"result\":\"FAIL\", \"reason\":\"EMAIL Already Used\"}";
		} else if (findByUsername(userName) != null && findByEmail(email) == null) {
			return "{\"result\":\"FAIL\", \"reason\":\"Name Already Used\"}";
		}
		return "{\"result\":\"FAIL\", \"reason\":\"EMAIL & Name Already Used\"}";
	}

	@Override
	public String login(String email, String password) {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(email);
		
		if (user.getPassword().equals(password))
			return "{\"result\": \"SUCCESS\",\"USER_ID\":\"" + user.getId() + "\"" + ",\"USER_NAME\":\""
					+ user.getUserName() + "\"}";
		return "{\"result\":\"FAIL\"}";
	}

	@Override
	public User findById(Long userId) {
		return userRepository.findOne(userId);
	}



}
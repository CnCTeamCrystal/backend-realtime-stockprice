package com.skcc.teamcrystal.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.teamcrystal.backend.entity.User;
import com.skcc.teamcrystal.backend.repository.UserRepository;
import com.skcc.teamcrystal.backend.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userservice;

	@Autowired
	UserRepository userreposi;

	@CrossOrigin
	@RequestMapping(value = "/user/add", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public String createUser(@RequestBody User user) {
		System.out.println("NAME:" + user.getUserName());
		System.out.println("E-Mail: " + user.getEmail());
		System.out.println("Pssword: " + user.getPassword());
		return userservice.createUser(user.getUserName(), user.getEmail(), user.getPassword());
	}

	@CrossOrigin
	@RequestMapping(value = "/user/all", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<User> uList() {
		return userreposi.findAll();
	}

	@CrossOrigin
	@RequestMapping(value = "/user/login", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public String login(@RequestBody User user) {
		System.out.println("E-Mail: " + user.getEmail());
		System.out.println("Pssword: " + user.getPassword());
		return userservice.login(user.getEmail(), user.getPassword());
	}
}

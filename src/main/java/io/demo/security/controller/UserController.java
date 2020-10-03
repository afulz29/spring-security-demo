package io.demo.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.demo.security.entity.User;
import io.demo.security.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "/users")
	public User getUserById(@RequestParam("userId") Integer userId) {
		return userService.getUserById(userId);
	}

	@PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
}

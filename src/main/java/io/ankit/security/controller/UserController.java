package io.ankit.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.ankit.security.entity.User;
import io.ankit.security.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "/users")
	public User getUserById(@RequestParam("userId") Integer userId) {
		return userService.getUserById(userId);
	}

	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
}

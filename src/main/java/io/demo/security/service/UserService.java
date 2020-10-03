package io.demo.security.service;

import org.springframework.stereotype.Service;

import io.demo.security.entity.User;

@Service
public interface UserService {

		User getUserById(Integer userId);

		User addUser(User user);

}

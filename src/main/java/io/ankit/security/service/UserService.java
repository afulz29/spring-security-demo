package io.ankit.security.service;

import org.springframework.stereotype.Service;

import io.ankit.security.entity.User;

@Service
public interface UserService {

		User getUserById(Integer userId);

		User addUser(User user);

}

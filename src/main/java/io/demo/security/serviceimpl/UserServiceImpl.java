package io.demo.security.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.demo.security.entity.User;
import io.demo.security.repository.UserRepository;
import io.demo.security.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User getUserById(Integer userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		User user = new User();
		if (optionalUser.isPresent()) {
			user = optionalUser.get();
		}
		return user;
	}

	@Override
	public User addUser(User user) {
		String password = user.getPassword();
		String encryptedPwd = passwordEncoder.encode(password);
		user.setPassword(encryptedPwd);
		return userRepository.save(user);
	}
}

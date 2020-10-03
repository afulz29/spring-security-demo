package io.ankit.security.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.ankit.security.entity.User;
import io.ankit.security.model.CustomUserDetails;
import io.ankit.security.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(userName);
		CustomUserDetails userDetails = new CustomUserDetails();
		if (user != null) {
			userDetails.setUser(user);
		} else {
			throw new UsernameNotFoundException("User not found with username = " + userName);
		}
		return userDetails;
	}
}

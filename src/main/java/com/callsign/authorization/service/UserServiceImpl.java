package com.callsign.authorization.service;

import com.callsign.authorization.exception.UserNotFoundException;
import com.callsign.authorization.model.User;
import com.callsign.authorization.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Shadab Khan
 * @since 08/01/2022
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public User loadUserByUsername(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		if (user.isPresent()) {
			return user.get();
		} else {
			log.error("user does not exist: {}", username);
			throw new UserNotFoundException("user does not exist");
		}
	}

}

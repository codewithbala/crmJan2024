package com.snva.crmproject.service;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.snva.crmproject.entity.userDetails.User;

public interface AuthenticationService extends UserDetailsService {

	User createUser(User user);

	User updatePassword(User user);

	User updateUser(Long id, User user);

	User updateUser(User user);

	Optional<User> getUserByUsername(String username);

	Optional<User> getUserByUserId(long userId);

	List<User> getAllUsers();

	User suspendUser(User user);
	User suspendUser(Long id);

	void deleteUser(Long id);

}

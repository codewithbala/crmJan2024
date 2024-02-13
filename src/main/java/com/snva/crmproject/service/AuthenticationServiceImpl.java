package com.snva.crmproject.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.snva.crmproject.entity.userDetails.User;
import com.snva.crmproject.repository.user.AuthenticationRepository;
import com.snva.crmproject.repository.user.UserPersonalDetailsRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Autowired
    AuthenticationRepository authenticationRepository;
    @Autowired
    UserPersonalDetailsRepository userPersonalDetailsRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = authenticationRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not present"));
        System.out.println(user.getRole());
        return user;
    }

    @Override
    public User createUser(User user) {
        if (authenticationRepository.findUserByUsername(user.getUsername()).isPresent()) {
            return null;
        }
        user.setAccountNonLocked(true);
        return authenticationRepository.save(user);
    }

    @Override
    public User updatePassword(User user) {
        User userDb = authenticationRepository.findUserByUsername(user.getUsername()).get();
        userDb.setPassword(user.getPassword());
        LOGGER.info("Updating password of " + user + " user");
        return authenticationRepository.save(userDb);
    }

    @Override
    public User updateUser(User user) {
        return updateUser(user.getId(), user);
    }

    @Override
    public User updateUser(Long id, User user) {
        return authenticationRepository.findById(id).map(existingUser -> {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
            existingUser.setRole(user.getRole());
            existingUser.setUserPersonalDetails(user.getUserPersonalDetails());
            existingUser.setAccountNonLocked(user.isAccountNonLocked());
            return authenticationRepository.save(existingUser);
        }).orElse(null);
    }

    @Override
    public Optional<User> getUserByUserId(long userId) {
        LOGGER.info("Pulling user from repository for id:" + userId);
        LOGGER.info(authenticationRepository.findById(userId)+"");
        LOGGER.info(userPersonalDetailsRepository.findById(userId)+"");
        return authenticationRepository.findById(userId);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        LOGGER.info("Pulling user from repository for username:" + username);
        return authenticationRepository.findUserByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return authenticationRepository.findAll();
    }

    //****************delete******************//
    @Override
    public User suspendUser(User user) {
        return suspendUser(user.getId());
    }

    @Override
    public User suspendUser(Long id) {
        LOGGER.info("######Suspend User with id:" + id);
        return authenticationRepository.findById(id).map(existingUser -> {
            existingUser.setAccountNonLocked(false);
            return authenticationRepository.save(existingUser);
        }).orElse(null);
    }

    @Override
    public User activateUser(User user) {
        return activateUser(user.getId());
    }

    @Override
    public User activateUser(Long id) {
        LOGGER.info("######Activate User with id:" + id);
        return authenticationRepository.findById(id).map(existingUser -> {
            existingUser.setAccountNonLocked(true);
            return authenticationRepository.save(existingUser);
        }).orElse(null);
    }

    
    @Transactional
    public void deleteUser(Long id) {
        authenticationRepository.deleteById(id);
    }

}

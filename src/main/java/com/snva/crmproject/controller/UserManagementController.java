package com.snva.crmproject.controller;

import com.snva.crmproject.entity.userDetails.User;
import com.snva.crmproject.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "${fontEnd.origins}")
@RequestMapping("/api/v1/users")
@RestController
public class UserManagementController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserManagementController.class);

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByUserId(@PathVariable long id) {
        LOGGER.info("pulling data for user with id:" + id);
        return authenticationService.getUserByUserId(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        LOGGER.info("pulling data for user with username:" + username);
        return authenticationService.getUserByUsername(username).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<User> getAllUsers() {
        LOGGER.info("pulling all users");
        return authenticationService.getAllUsers();
    }

    @PutMapping("/{id}")
    User updateUser(@PathVariable Long id, @RequestBody User user) {
        LOGGER.info("Updating " + user.getUsername() + " user");
        return authenticationService.updateUser(id, user);
    }

    //TODO legacy of previous api version
    @PostMapping("/changePassword")
    User updatePassword(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return authenticationService.updatePassword(user);
    }

    @PutMapping("/suspend/{id}")
    User suspendUser(@PathVariable Long id) {
        LOGGER.info("suspending user with id:" + id);
        return authenticationService.suspendUser(id);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable long id) {
        LOGGER.info("deleting user with '" + id + "' id");
        authenticationService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}

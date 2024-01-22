package com.snva.crmproject.controller;

import com.snva.crmproject.entity.userDetails.User;
import com.snva.crmproject.service.AuthenticationService;
import com.snva.crmproject.utility.Roles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "${fontEnd.origins}")
@RequestMapping("/api/v1/users")
@RestController
public class CreateUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateUserController.class);

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //TODO relatively dangerous to leave unsecure way to create super admin users
    @PostMapping("/register")
    public ResponseEntity<User> createSuperAdmin(@RequestBody User user) {
        return createUser(user);
    }

    private ResponseEntity<User> createUser(User user) {
        return createUser(user, user.getRole());
    }

    @PreAuthorize("hasAuthority('" + Roles.SUPER_ADMIN + "')")
    @PostMapping("/recruiter_admin")
    ResponseEntity<User> createRecruiterAdmin(@RequestBody User user) {
        return createUser(user, Roles.RECRUITER_ADMIN);
    }

    @PreAuthorize("hasAuthority('" + Roles.SUPER_ADMIN + "')")
    @PostMapping("/trainer_admin")
    ResponseEntity<User> createTrainerAdmin(@RequestBody User user) {
        return createUser(user, Roles.TRAINER_ADMIN);
    }

    @PreAuthorize("hasAuthority('" + Roles.SUPER_ADMIN + "')")
    @PostMapping("/bd_admin")
    ResponseEntity<User> createBdAdmin(@RequestBody User user) {
        return createUser(user, Roles.BUSINESS_DEV_ADMIN);
    }

    @PreAuthorize("hasAuthority('" + Roles.SUPER_ADMIN + "') OR hasAuthority('" + Roles.RECRUITER_ADMIN + "')")
    @PostMapping("/recruiter")
    ResponseEntity<User> createRecruiter(@RequestBody User user) {
        return createUser(user, Roles.RECRUITER);
    }

    @PreAuthorize("hasAuthority('" + Roles.SUPER_ADMIN + "') OR hasAuthority('" + Roles.TRAINER_ADMIN + "')")
    @PostMapping("/trainer")
    ResponseEntity<User> createTrainer(@RequestBody User user) {
        return createUser(user, Roles.TRAINER);
    }

    @PreAuthorize("hasAuthority('" + Roles.SUPER_ADMIN + "') OR hasAuthority('" + Roles.BUSINESS_DEV_ADMIN + "')")
    @PostMapping("/bd")
    ResponseEntity<User> createBusinessDev(@RequestBody User user) {
        return createUser(user, Roles.BUSINESS_DEV);
    }

    private ResponseEntity<User> createUser(User user, String role) {
        LOGGER.info("Creating " + user.getUsername() + " user with " + role + " role");
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (authenticationService.createUser(user) == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(user);
    }

}

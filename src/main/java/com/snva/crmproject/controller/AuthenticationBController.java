package com.snva.crmproject.controller;

import com.snva.crmproject.entity.userDetails.User;
import com.snva.crmproject.service.AuthServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@CrossOrigin(origins = "${fontEnd.origins}")
@RequestMapping("/api/v1/authentication")
@RestController
public class AuthenticationBController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationBController.class);

    @Autowired
    private AuthServiceImpl authenticationService;

    @RequestMapping
    public ResponseEntity<User> login(Principal user) {
        LOGGER.info("login for " + user.getName() + " user");
        return authenticationService.getUserByUsername(user.getName()).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}

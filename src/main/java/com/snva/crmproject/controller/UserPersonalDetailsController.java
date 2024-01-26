package com.snva.crmproject.controller;

import com.snva.crmproject.entity.userDetails.UserPersonalDetails;
import com.snva.crmproject.service.UserPersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "${fontEnd.origins}")
@RestController
@RequestMapping("/api/v1/users/personal-details")
public class UserPersonalDetailsController {

    private final UserPersonalDetailsService personalDetailsService;

    @Autowired
    public UserPersonalDetailsController(UserPersonalDetailsService personalDetailsService) {
        this.personalDetailsService = personalDetailsService;
    }

    @PostMapping
    public ResponseEntity<UserPersonalDetails> createPersonalDetails(@RequestBody UserPersonalDetails personalDetails) {
    	UserPersonalDetails createdBatch = personalDetailsService.createPersonalDetails(personalDetails);
        return ResponseEntity.ok(createdBatch);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserPersonalDetails> getPersonalDetailsById(@PathVariable Long id) {
    	System.out.println(id);
        return personalDetailsService.findPersonalDetailsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<UserPersonalDetails> getAllPersonalDetails() {
        return personalDetailsService.findAllPersonalDetails();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserPersonalDetails> updatePersonalDetails(@PathVariable Long id,
                                                                     @RequestBody UserPersonalDetails personalDetails) {
    	System.out.println(personalDetails);
        UserPersonalDetails updatedBatch = personalDetailsService.updatePersonalDetails(id, personalDetails);
        if (updatedBatch != null) {
            return ResponseEntity.ok(updatedBatch);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonalDetails(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body("Delete method not supported for this resource");
    }
}

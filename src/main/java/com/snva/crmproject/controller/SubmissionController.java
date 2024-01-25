package com.snva.crmproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.snva.crmproject.entity.SubmissionDetails.Submission;
import com.snva.crmproject.service.SubmissionService;


@CrossOrigin(origins = "${fontEnd.origins}")
@RestController
@RequestMapping("/api/v1/submissions")
public class SubmissionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubmissionController.class);

    private final SubmissionService submissionService;

    @Autowired
    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @PostMapping
    public ResponseEntity<Submission> createSubmission(@RequestBody Submission submission) {
        LOGGER.info("Received Submission: {}", submission);
        Submission createdSubmission = submissionService.createSubmission(submission);
        return ResponseEntity.ok(createdSubmission);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Submission> getSubmissionById(@PathVariable Long id) {
        LOGGER.info("Pulling data for submission with id", id);
        return submissionService.findSubmissionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Submission>> getAllSubmissions() {
        LOGGER.info("Pulling data for all submission");
        List<Submission> submissions = submissionService.findAllSubmissions();
        return ResponseEntity.ok(submissions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Submission> updateSubmission(@PathVariable Long id, @RequestBody Submission submission) {
        LOGGER.info("Updating data for submission for id " + id);
    	Submission updatedSubmission = submissionService.updateSubmission(id, submission);
        return ResponseEntity.ok(updatedSubmission);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubmission(@PathVariable Long id) {
        LOGGER.info("Deleting data for submission :" + id);
        submissionService.deleteSubmission(id);
        return ResponseEntity.ok().build();
    }
}
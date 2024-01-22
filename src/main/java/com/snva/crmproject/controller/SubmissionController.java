package com.snva.crmproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snva.crmproject.entity.SubmissionDetails.Submission;
import com.snva.crmproject.service.SubmissionService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

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
        return submissionService.findSubmissionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Submission>> getAllSubmissions() {
        List<Submission> submissions = submissionService.findAllSubmissions();
        return ResponseEntity.ok(submissions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Submission> updateSubmission(@PathVariable Long id, @RequestBody Submission submission) {
        Submission updatedSubmission = submissionService.updateSubmission(id, submission);
        return ResponseEntity.ok(updatedSubmission);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubmission(@PathVariable Long id) {
        submissionService.deleteSubmission(id);
        return ResponseEntity.ok().build();
    }
}
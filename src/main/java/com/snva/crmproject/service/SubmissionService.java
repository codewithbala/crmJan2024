package com.snva.crmproject.service;


import java.util.List;
import java.util.Optional;
import com.snva.crmproject.entity.SubmissionDetails.Submission;

public interface SubmissionService {
    Submission createSubmission(Submission submission);
    Optional<Submission> findSubmissionById(Long id);
    List<Submission> findAllSubmissions();
    Submission updateSubmission(Long id, Submission submission);
    void deleteSubmission(Long id);
}
package com.snva.crmproject.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snva.crmproject.entity.SubmissionDetails.Submission;
import com.snva.crmproject.repository.Submission.SubmissionRepository;
@Service
public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionRepository submissionRepository;

    public SubmissionServiceImpl(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    @Override
    @Transactional
    public Submission createSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Submission> findSubmissionById(Long id) {
        return submissionRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Submission> findAllSubmissions() {
        return submissionRepository.findAll();
    }

    @Override
    @Transactional
    public Submission updateSubmission(Long id, Submission submissionDetails) {
        return submissionRepository.findById(id)
            .map(existingSubmission -> {
                existingSubmission.setDateOfSubmission(submissionDetails.getDateOfSubmission());
                existingSubmission.setBdeName(submissionDetails.getBdeName());
                existingSubmission.setPositionTitle(submissionDetails.getPositionTitle());
                existingSubmission.setCandidateId(submissionDetails.getCandidateId());
                existingSubmission.setVendorId(submissionDetails.getVendorId());
                existingSubmission.setEndClientId(submissionDetails.getEndClientId());
                existingSubmission.setBillRate(submissionDetails.getBillRate());
                existingSubmission.setBillRateAnnual(submissionDetails.getBillRateAnnual());
                existingSubmission.setSubmissionStatus(submissionDetails.getSubmissionStatus());
                existingSubmission.setInterviewId(submissionDetails.getInterviewId());
                existingSubmission.setProjectStartDate(submissionDetails.getProjectStartDate());
                existingSubmission.setProjectEndDate(submissionDetails.getProjectEndDate());
                existingSubmission.setRemarks(submissionDetails.getRemarks());
                return submissionRepository.save(existingSubmission);
            })
            .orElseThrow(() -> new RuntimeException("Submission not found with id " + id));
    }

    @Override
    @Transactional
    public void deleteSubmission(Long id) {
        submissionRepository.deleteById(id);
    }
}
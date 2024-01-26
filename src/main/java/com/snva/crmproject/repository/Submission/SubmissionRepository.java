package com.snva.crmproject.repository.Submission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snva.crmproject.entity.SubmissionDetails.Submission;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
package com.snva.crmproject.entity.batchDetails;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.snva.crmproject.entity.CandidateDetails;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table(name = "batch_candidates")
@IdClass(BatchCandidatesId.class)
public class BatchCandidates {

	@Id
    @ManyToOne
    @JoinColumn(name = "batch_id", nullable = false)
    private Batch batch;

    @Id
    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private CandidateDetails candidate;


    // Constructors, getters, and setters

    public BatchCandidates() {
    }

    public BatchCandidates(Batch batch, CandidateDetails candidate) {
        this.batch = batch;
        this.candidate = candidate;
    }

    // Getters and setters
  

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public CandidateDetails getCandidate() {
        return candidate;
    }

    public void setCandidate(CandidateDetails candidate) {
        this.candidate = candidate;
    }
}

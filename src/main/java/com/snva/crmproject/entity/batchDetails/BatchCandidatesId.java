package com.snva.crmproject.entity.batchDetails;

import java.io.Serializable;
import java.util.Objects;

public class BatchCandidatesId implements Serializable {
    private Long batch; 
    private String candidate; 

    public BatchCandidatesId() {
    }

    public BatchCandidatesId(Long batch, String candidate) {
        this.batch = batch;
        this.candidate = candidate;
    }

	public Long getBatch() {
		return batch;
	}

	public void setBatch(Long batch) {
		this.batch = batch;
	}

	public String getCandidate() {
		return candidate;
	}

	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}

   
}

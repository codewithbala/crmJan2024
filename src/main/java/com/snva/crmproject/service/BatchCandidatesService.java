package com.snva.crmproject.service;

import java.util.List;
import java.util.Optional;

import com.snva.crmproject.entity.batchDetails.BatchCandidates;

public interface BatchCandidatesService {
    BatchCandidates createBatchCandidate(BatchCandidates batchCandidate);
    List<BatchCandidates> findAllBatchCandidates();
    BatchCandidates updateBatchCandidate(BatchCandidates batchCandidate);
    void deleteBatchCandidate(Long batchId, String candidateId);
    List<BatchCandidates> findBatchCandidatesByBatchId(Long batchId);

}
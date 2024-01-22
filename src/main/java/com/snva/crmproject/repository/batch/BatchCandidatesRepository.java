package com.snva.crmproject.repository.batch;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.snva.crmproject.entity.batchDetails.BatchCandidates;
import com.snva.crmproject.entity.batchDetails.BatchCandidatesId;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
@Repository
public interface BatchCandidatesRepository extends JpaRepository<BatchCandidates, BatchCandidatesId> {
	@Modifying
    @Transactional
    @Query("DELETE FROM BatchCandidates bc WHERE bc.batch.id = :batchId AND bc.candidate.candidateId = :candidateId")
	void deleteBatchCandidate(Long batchId, String candidateId);
    List<BatchCandidates> findByBatchId(Long batchId);

}

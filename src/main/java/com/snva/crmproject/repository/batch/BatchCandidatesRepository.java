package com.snva.crmproject.repository.batch;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.snva.crmproject.entity.batchDetails.BatchCandidates;

@Repository
public interface BatchCandidatesRepository extends JpaRepository<BatchCandidates, Long> {
    List<BatchCandidates> findByBatchId(Long batchId);
}

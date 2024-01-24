package com.snva.crmproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.snva.crmproject.entity.batchDetails.BatchCandidates;
import com.snva.crmproject.entity.batchDetails.BatchCandidatesId;
import com.snva.crmproject.repository.batch.BatchCandidatesRepository;
import java.util.List;
import java.util.Optional;

@Service
public class BatchCandidatesServiceImpl implements BatchCandidatesService {

    private final BatchCandidatesRepository batchCandidatesRepository;

    @Autowired
    public BatchCandidatesServiceImpl(BatchCandidatesRepository batchCandidatesRepository) {
        this.batchCandidatesRepository = batchCandidatesRepository;
    }

    @Override
    @Transactional
    public BatchCandidates createBatchCandidate(BatchCandidates batchCandidate) {
        return batchCandidatesRepository.save(batchCandidate);
    }

  

    @Override
    @Transactional(readOnly = true)
    public List<BatchCandidates> findAllBatchCandidates() {
        return batchCandidatesRepository.findAll();
    }

    @Override
    @Transactional
    public BatchCandidates updateBatchCandidate(BatchCandidates batchCandidate) {
        return batchCandidatesRepository.save(batchCandidate);
    }

    @Override
    @Transactional
    public void deleteBatchCandidate(Long batchId, String candidateId) {
        BatchCandidatesId id = new BatchCandidatesId(batchId, candidateId);
        batchCandidatesRepository.deleteById(id);
    }
    
	@Override
	public List<BatchCandidates> findBatchCandidatesByBatchId(Long batchId) {
        return batchCandidatesRepository.findByBatchId(batchId);

	}
	
}

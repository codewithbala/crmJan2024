package com.snva.crmproject.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snva.crmproject.entity.batchDetails.Batch;
import com.snva.crmproject.repository.batch.BatchRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BatchServiceImpl implements BatchService {

    private final BatchRepository batchRepository;

    @Autowired
    public BatchServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @Override
    @Transactional
    public Batch createBatch(Date startDate, String batchType, String status) {
        Batch batch = new Batch();
        batch.setStartDate(startDate);
        batch.setBatchType(batchType);
        batch.setStatus(status);
        return batchRepository.save(batch);
    }

    @Override
    public Optional<Batch> findBatchById(Long id) {
        return batchRepository.findById(id);
    }

    @Override
    public List<Batch> findAllBatches() {
        return batchRepository.findAll();
    }

    @Override
    @Transactional
    public Batch updateBatch(Long id, Date startDate, String batchType, String status) {
        return batchRepository.findById(id).map(batch -> {
            batch.setStartDate(startDate);
            batch.setBatchType(batchType);
            batch.setStatus(status);
            return batchRepository.save(batch);
        }).orElse(null);
    }

    @Override
    @Transactional
    public void deleteBatch(Long id) {
        batchRepository.deleteById(id);
    }
}
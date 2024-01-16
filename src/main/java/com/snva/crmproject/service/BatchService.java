package com.snva.crmproject.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.snva.crmproject.entity.batchDetails.Batch;

public interface BatchService {
    Batch createBatch(Date startDate, String batchType, String status);
    Optional<Batch> findBatchById(Long id);
    List<Batch> findAllBatches();
    Batch updateBatch(Long id, Date startDate, String batchType, String status);
    void deleteBatch(Long id);
}
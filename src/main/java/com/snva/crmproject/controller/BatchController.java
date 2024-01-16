package com.snva.crmproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.snva.crmproject.entity.batchDetails.Batch;
import com.snva.crmproject.service.BatchService;

import java.util.List;

@RestController
@RequestMapping("/api/batches")
public class BatchController {

    private final BatchService batchService;

    @Autowired
    public BatchController(BatchService batchService) {
        this.batchService = batchService;
    }

    @PostMapping("/create")
    public ResponseEntity<Batch> createBatch(@RequestBody Batch batch) {
        batchService.createBatch(batch.getStartDate(), batch.getBatchType(), batch.getStatus());
        return ResponseEntity.ok(batch);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Batch> getBatchById(@PathVariable Long id) {
        return batchService.findBatchById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Batch> getAllBatches() {
        return batchService.findAllBatches();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Batch> updateBatch(@RequestBody Batch batch) {
        Batch updatedBatch = batchService.updateBatch(batch.getId(), batch.getStartDate(), batch.getBatchType(), batch.getStatus());
        if (updatedBatch != null) {
            return ResponseEntity.ok(updatedBatch);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBatch(@PathVariable Long id) {
        batchService.deleteBatch(id);
        return ResponseEntity.ok().build();
    }
}

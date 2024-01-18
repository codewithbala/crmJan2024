package com.snva.crmproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.snva.crmproject.entity.batchDetails.BatchCandidates;
import com.snva.crmproject.service.BatchCandidatesService;
import java.util.List;

@CrossOrigin(origins = "${fontEnd.origins}")
@RestController
@RequestMapping("/api/v1/batch-candidates")
public class BatchCandidatesController {

    private final BatchCandidatesService batchCandidatesService;

    @Autowired
    public BatchCandidatesController(BatchCandidatesService batchCandidatesService) {
        this.batchCandidatesService = batchCandidatesService;
    }

    @PostMapping
    public ResponseEntity<BatchCandidates> createBatchCandidate(@RequestBody BatchCandidates batchCandidate) {
        BatchCandidates createdBatchCandidate = batchCandidatesService.createBatchCandidate(batchCandidate);
        return ResponseEntity.ok(createdBatchCandidate);
    }

    @GetMapping("/{batchId}")
    public ResponseEntity<List<BatchCandidates>> getBatchCandidatesByBatchId(@PathVariable Long batchId) {
        List<BatchCandidates> batchCandidates = batchCandidatesService.findBatchCandidatesByBatchId(batchId);
        return ResponseEntity.ok(batchCandidates);
    }

    @GetMapping
    public List<BatchCandidates> getAllBatchCandidates() {
        return batchCandidatesService.findAllBatchCandidates();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BatchCandidates> updateBatchCandidate(@PathVariable Long id, @RequestBody BatchCandidates batchCandidate) {
        BatchCandidates updatedBatchCandidate = batchCandidatesService.updateBatchCandidate(batchCandidate);
        if (updatedBatchCandidate != null) {
            return ResponseEntity.ok(updatedBatchCandidate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBatchCandidate(@PathVariable Long id) {
        batchCandidatesService.deleteBatchCandidate(id);
        return ResponseEntity.ok().build();
    }
}

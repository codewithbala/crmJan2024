package com.snva.crmproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(BatchCandidatesController.class);

    private final BatchCandidatesService batchCandidatesService;

    @Autowired
    public BatchCandidatesController(BatchCandidatesService batchCandidatesService) {
        this.batchCandidatesService = batchCandidatesService;
    }

    @PostMapping
    public ResponseEntity<BatchCandidates> createBatchCandidate(@RequestBody BatchCandidates batchCandidate) {
        LOGGER.info("creating candidate data for batch with id: " + batchCandidate.getBatch().getId());
    	BatchCandidates createdBatchCandidate = batchCandidatesService.createBatchCandidate(batchCandidate);
        return ResponseEntity.ok(createdBatchCandidate);
    }

    @GetMapping("/{batchId}")
    public ResponseEntity<List<BatchCandidates>> getBatchCandidatesByBatchId(@PathVariable Long batchId) {
        LOGGER.info("pulling candidate data for batch with id: " + batchId);
    	List<BatchCandidates> batchCandidates = batchCandidatesService.findBatchCandidatesByBatchId(batchId);
        return ResponseEntity.ok(batchCandidates);
    }

    @GetMapping
    public List<BatchCandidates> getAllBatchCandidates() {
        LOGGER.info("pulling candidate data for entire batch");
        return batchCandidatesService.findAllBatchCandidates();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BatchCandidates> updateBatchCandidate(@PathVariable Long id, @RequestBody BatchCandidates batchCandidate) {
        BatchCandidates updatedBatchCandidate = batchCandidatesService.updateBatchCandidate(batchCandidate);
        LOGGER.info("Updating candidate data for " + batchCandidate.getBatch());

        if (updatedBatchCandidate != null) {
            return ResponseEntity.ok(updatedBatchCandidate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBatchCandidate(@PathVariable Long id) {
        LOGGER.info("deleting candidate data for batch with id:" + id);

        batchCandidatesService.deleteBatchCandidate(id);
        return ResponseEntity.ok().build();
    }
}

package com.snva.crmproject.controller;

import com.snva.crmproject.entity.batchUser.BatchUser;
import com.snva.crmproject.entity.batchUser.BatchUsersId;
import com.snva.crmproject.service.BatchUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="${fontEnd.origins}")
@RequestMapping("/api/v1/batch-users")
public class BatchUserController {
    private static  final Logger logger = LoggerFactory.getLogger(BatchUserController.class);
    @Autowired
    private BatchUserService batchUserService;

    @PostMapping
    public ResponseEntity<BatchUser> createBatchUser(@RequestBody BatchUser batchUser) {
        return new ResponseEntity<>(batchUserService.createBatchUser(batchUser), HttpStatus.CREATED);
    }

    // Endpoint to get BatchUser by composite ID
    @GetMapping("/{batchId}/{userId}")
    public ResponseEntity<BatchUser> getBatchUserById(@PathVariable Long batchId, @PathVariable Long userId) {
        BatchUsersId id = new BatchUsersId(batchId, userId);
        return batchUserService.getBatchUserById(id)
                .map(batchUser -> new ResponseEntity<>(batchUser, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<BatchUser>> getAllBatchUsers() {
        return new ResponseEntity<>(batchUserService.getAllBatchUsers(), HttpStatus.OK);
    }

    // Endpoint to update BatchUser by composite ID
    @PutMapping("/{batchId}/{userId}")
    public ResponseEntity<BatchUser> updateBatchUser(@PathVariable Long batchId, @PathVariable Long userId, @RequestBody BatchUser batchUser) {
        try {
            BatchUsersId id = new BatchUsersId(batchId, userId);
            BatchUser updatedBatchUser = batchUserService.updateBatchUser(batchUser);
            return new ResponseEntity<>(updatedBatchUser, HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Endpoint to delete BatchUser by composite ID
    @DeleteMapping("/{batchId}/{userId}")
    public ResponseEntity<Void> deleteBatchUser(@PathVariable Long batchId, @PathVariable Long userId) {
        try {
            BatchUsersId id = new BatchUsersId(batchId, userId);
            batchUserService.deleteBatchUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

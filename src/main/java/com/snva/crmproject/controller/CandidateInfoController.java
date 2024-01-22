package com.snva.crmproject.controller;

import com.snva.crmproject.entity.CandidateBasicDetails;
import com.snva.crmproject.service.CandidateBasicDetailsService;
import com.snva.crmproject.service.CandidateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="${fontEnd.origins}")
@RequestMapping("/api/v1/candidates")

public class CandidateInfoController {
    private static  final Logger logger = LoggerFactory.getLogger(CandidateInfoController.class);

    @Autowired
    private CandidateService candidateService;

    private final CandidateBasicDetailsService candidateBasicDetailsService;

    @Autowired
    public CandidateInfoController( CandidateBasicDetailsService candidateBasicDetailsService){

        this.candidateBasicDetailsService = candidateBasicDetailsService;

    }

    @GetMapping()
    public ResponseEntity<List<CandidateBasicDetails>> getAllCandidates() {
        return new ResponseEntity<>(candidateBasicDetailsService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{candidateId}")
    public ResponseEntity<CandidateBasicDetails> getCandidateById(@PathVariable String candidateId) {
        return new ResponseEntity<>(candidateBasicDetailsService.findById(candidateId), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CandidateBasicDetails> updateCandidate(@PathVariable String id, @RequestBody CandidateBasicDetails candidateBasicDetails) {
        return new ResponseEntity<>(candidateBasicDetailsService.update(id, candidateBasicDetails), HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<CandidateBasicDetails> addCandidate(@RequestBody CandidateBasicDetails candidateBasicDetails) {
        return new ResponseEntity<>(candidateBasicDetailsService.add(candidateBasicDetails), HttpStatus.CREATED);
    }

    @DeleteMapping("/{candidateId}")
    public ResponseEntity<String> deleteCandidate(@PathVariable String candidateId) {
        candidateBasicDetailsService.delete(candidateId);
        return new ResponseEntity<>("Candidate deleted successfully", HttpStatus.OK);
    }

}

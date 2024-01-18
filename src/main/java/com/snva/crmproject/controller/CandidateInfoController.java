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
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/Candidates")

public class CandidateInfoController {
    private static  final Logger logger = LoggerFactory.getLogger(CandidateInfoController.class);

    @Autowired
    private CandidateService candidateService;

    private final CandidateBasicDetailsService candidateBasicDetailsService;

    @Autowired
    public CandidateInfoController( CandidateBasicDetailsService candidateBasicDetailsService){

        this.candidateBasicDetailsService = candidateBasicDetailsService;

    }

    @GetMapping("/all")
    public ResponseEntity<List<CandidateBasicDetails>> getAllCandidates() {
        return new ResponseEntity<>(candidateBasicDetailsService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{candidateId}")
    public ResponseEntity<CandidateBasicDetails> getCandidateById(@PathVariable String candidateId) {
        return new ResponseEntity<>(candidateBasicDetailsService.findById(candidateId), HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<CandidateBasicDetails> updateCandidate(@RequestBody CandidateBasicDetails candidateBasicDetails) {
        return new ResponseEntity<>(candidateBasicDetailsService.update(candidateBasicDetails), HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<CandidateBasicDetails> addCandidate(@RequestBody CandidateBasicDetails candidateBasicDetails) {
        return new ResponseEntity<>(candidateBasicDetailsService.add(candidateBasicDetails), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{candidateId}")
    public ResponseEntity<String> deleteCandidate(@PathVariable String candidateId) {
        candidateBasicDetailsService.delete(candidateId);
        return new ResponseEntity<>("Candidate deleted successfully", HttpStatus.OK);
    }

}

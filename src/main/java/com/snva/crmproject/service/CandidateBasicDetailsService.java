package com.snva.crmproject.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snva.crmproject.entity.CandidateBasicDetails;
import com.snva.crmproject.repository.candidate.CandidateBasicDetailsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateBasicDetailsService {

    private final CandidateBasicDetailsRepository candidateBasicDetailsRepository;

    @Autowired
    public CandidateBasicDetailsService(CandidateBasicDetailsRepository candidateBasicDetailsRepository) {
        this.candidateBasicDetailsRepository = candidateBasicDetailsRepository;
    }

    public Optional<CandidateBasicDetails> getCandidateBasicDetailsById(String candidateId) {
        return candidateBasicDetailsRepository.findById(candidateId);
    }

    public List<CandidateBasicDetails> findAll() {
        return candidateBasicDetailsRepository.findAll();
    }

    public CandidateBasicDetails findById(String candidateId) {
        return candidateBasicDetailsRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
    }

    public CandidateBasicDetails update(CandidateBasicDetails candidateBasicDetails) {
        if (candidateBasicDetailsRepository.existsById(candidateBasicDetails.getCandidateId())) {
            return candidateBasicDetailsRepository.save(candidateBasicDetails);
        } else {
            throw new RuntimeException("Candidate not found");
        }
    }

    public void delete(String candidateId) {
        candidateBasicDetailsRepository.deleteById(candidateId);
    }

    public CandidateBasicDetails add(CandidateBasicDetails candidateBasicDetails) {
        return candidateBasicDetailsRepository.save(candidateBasicDetails);
    }
}
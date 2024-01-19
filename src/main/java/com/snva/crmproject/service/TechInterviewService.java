package com.snva.crmproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snva.crmproject.entity.CandidateBasicDetails;
import com.snva.crmproject.entity.CandidateDetails;
import com.snva.crmproject.entity.TechInterview;
import com.snva.crmproject.repository.TechInterviewRepository;
import com.snva.crmproject.repository.candidate.CandidateBasicDetailsRepository;

@Service
public class TechInterviewService {
	
	
	@Autowired
	    private TechInterviewRepository techInterviewRepository;
	@Autowired
	CandidateBasicDetailsRepository candidatebasicdetailrepository;

	    
	    
	        public List<TechInterview> getAllTechInterviews() {
	            return techInterviewRepository.findAll();
	        }

	        public TechInterview getTechInterviewById(Long id) {
	        	
	            Optional<TechInterview> techInterviewOptional = techInterviewRepository.findById(id);

	        
	            return techInterviewOptional.orElse(null);
	        }
	       
	        
             public TechInterview createTechInterview(TechInterview techInterview) {
	           
	        	
	            CandidateBasicDetails candidate = techInterview.getCandidateBasicDetails();
	            if (candidate != null && candidate.getCandidateId() != null) {
	                
	                candidate = candidatebasicdetailrepository.findById(candidate.getCandidateId()).orElse(null);
	                techInterview.setCandidateBasicDetails(candidate);
	            }

	            return techInterviewRepository.save(techInterview);
	        }

	        

	        public TechInterview updateTechInterview(Long id, TechInterview updatedInterview) {
	            TechInterview existingInterview = techInterviewRepository.findById(id).orElse(null);
	            if (existingInterview != null) {
	               
	                existingInterview.setInterviewDate(updatedInterview.getInterviewDate());
	                existingInterview.setInterviewer(updatedInterview.getInterviewer());
	                existingInterview.setInterviewerFeedback(updatedInterview.getInterviewerFeedback());
	                existingInterview.setCandidateInterviewStatus(updatedInterview.getCandidateInterviewStatus());

	                return techInterviewRepository.save(existingInterview);
	            }
	            return null; 
	        }

	        public void deleteTechInterview(Long id) {
	            techInterviewRepository.deleteById(id);
	        }
	    }

	
	




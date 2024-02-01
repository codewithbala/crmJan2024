package com.snva.crmproject.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snva.crmproject.entity.CandidateDetails;
import com.snva.crmproject.entity.EndClient;
import com.snva.crmproject.entity.Vendor;
import com.snva.crmproject.entity.SubmissionDetails.Submission;
import com.snva.crmproject.entity.customerInterview.CustomerInterview;
import com.snva.crmproject.repository.EndClientRepository;
import com.snva.crmproject.repository.VendorRepository;
import com.snva.crmproject.repository.Submission.SubmissionRepository;
import com.snva.crmproject.repository.candidate.CandidateDetailsRepository;
import com.snva.crmproject.repository.customerInterview.CustomerInterviewRepository;

import jakarta.persistence.EntityNotFoundException;
@Service
public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionRepository submissionRepository;
    @Autowired
    private VendorRepository vendorRepository;
    
    @Autowired
    private CandidateDetailsRepository candidateDetailsRepository;
    
    
    @Autowired
    private EndClientRepository endClientRepository;
    
    @Autowired
    private CustomerInterviewRepository customerInterviewRepository;
    
    public SubmissionServiceImpl(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }
    


    @Override
    @Transactional
    public Submission createSubmission(Submission submission) {
    	
    	
    	
    	if (submission.getVendor() != null) {
    	    if (submission.getVendor().getId() != null) {
    	        Vendor existingVendor = vendorRepository.findById(submission.getVendor().getId())
    	                .orElseThrow(() -> new EntityNotFoundException("Vendor not found with id: " + submission.getVendor().getId()));
    	        submission.setVendor(existingVendor);
    	    } else {
    	        Vendor savedVendor = vendorRepository.save(submission.getVendor());
    	        submission.setVendor(savedVendor);
    	    }
    	}
    	
        if (submission.getCandidateDetails() != null) {
            if (submission.getCandidateDetails().getCandidateId() != null) {
                CandidateDetails existingCandidateDetails = candidateDetailsRepository.findById(submission.getCandidateDetails().getCandidateId())
                        .orElseThrow(() -> new EntityNotFoundException("CandidateDetails not found with id: " + submission.getCandidateDetails().getCandidateId()));
                submission.setCandidateDetails(existingCandidateDetails);
            } else {
                CandidateDetails savedCandidateDetails = candidateDetailsRepository.save(submission.getCandidateDetails());
                submission.setCandidateDetails(savedCandidateDetails);
            }
        }
    	  
    	  
           
           
           if (submission.getEndClient() != null) {
               if (submission.getEndClient().getId() != null) {
                   EndClient existingEndClient = endClientRepository.findById(submission.getEndClient().getId())
                           .orElseThrow(() -> new EntityNotFoundException("EndClient not found with id: " + submission.getEndClient().getId()));
                   submission.setEndClient(existingEndClient);
               } else {
                   EndClient savedEndClient = endClientRepository.save(submission.getEndClient());
                   submission.setEndClient(savedEndClient);
               }
           }
          
        

          if (submission.getCustomerInterview() != null) {
        	    CustomerInterview customerInterview = submission.getCustomerInterview();
        	    if (customerInterview.getInterviewID() != null) {
        	        CustomerInterview existingInterview = customerInterviewRepository.findById(customerInterview.getInterviewID())
        	                .orElseThrow(() -> new EntityNotFoundException("CustomerInterview not found with id: " + customerInterview.getInterviewID()));
        	        submission.setCustomerInterview(existingInterview);
        	    } else {
        	        CustomerInterview savedInterview = customerInterviewRepository.save(customerInterview);
        	        submission.setCustomerInterview(savedInterview);
        	    }
        	}
          
          
          return submissionRepository.save(submission);

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Submission> findSubmissionById(Long id) {
        return submissionRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Submission> findAllSubmissions() {
        return submissionRepository.findAll();
    }

    @Override
    @Transactional
    public Submission updateSubmission(Long id, Submission submissionDetails) {
        return submissionRepository.findById(id)
            .map(existingSubmission -> {
            	System.out.println("Update");
                existingSubmission.setDateOfSubmission(submissionDetails.getDateOfSubmission());
                existingSubmission.setBdeName(submissionDetails.getBdeName());
                existingSubmission.setPositionTitle(submissionDetails.getPositionTitle());
                existingSubmission.setCandidateDetails(submissionDetails.getCandidateDetails());
                existingSubmission.setVendor(submissionDetails.getVendor());
                existingSubmission.setEndClient(submissionDetails.getEndClient());
                existingSubmission.setBillRate(submissionDetails.getBillRate());
                existingSubmission.setBillRateAnnual(submissionDetails.getBillRateAnnual());
                existingSubmission.setSubmissionStatus(submissionDetails.getSubmissionStatus());
                existingSubmission.setCustomerInterview(submissionDetails.getCustomerInterview());
                existingSubmission.setProjectStartDate(submissionDetails.getProjectStartDate());
                existingSubmission.setProjectEndDate(submissionDetails.getProjectEndDate());
                existingSubmission.setRemarks(submissionDetails.getRemarks());
                return submissionRepository.save(existingSubmission);
            })
            .orElseThrow(() -> new RuntimeException("Submission not found with id " + id));
    }

    @Override
    @Transactional
    public void deleteSubmission(Long id) {
        submissionRepository.deleteById(id);
    }
}
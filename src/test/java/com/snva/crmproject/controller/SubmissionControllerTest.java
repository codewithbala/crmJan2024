package com.snva.crmproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.snva.crmproject.CrmProjectApplication;
import com.snva.crmproject.entity.SubmissionDetails.Submission;
import com.snva.crmproject.entity.customerInterview.CustomerInterview;
import com.snva.crmproject.entity.CandidateDetails;
import com.snva.crmproject.entity.EndClient;
import com.snva.crmproject.entity.Vendor;
import com.snva.crmproject.repository.EndClientRepository;
import com.snva.crmproject.repository.VendorRepository;
import com.snva.crmproject.repository.Submission.SubmissionRepository;
import com.snva.crmproject.repository.candidate.CandidateDetailsRepository;
import com.snva.crmproject.repository.customerInterview.CustomerInterviewRepository;
import com.snva.crmproject.utility.TestUser;

import jakarta.transaction.Transactional;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = CrmProjectApplication.class)
@AutoConfigureMockMvc
public class SubmissionControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private SubmissionRepository submissionRepository;

	@Autowired
	private CandidateDetailsRepository candidateDetailsRepository;
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@Autowired
	private EndClientRepository endClientRepository;
	
	@Autowired
	private CustomerInterviewRepository customerInterviewRepository;

	private static Submission testSubmission;
	private static CandidateDetails testCandidate;
	private static String resourceCall = "/api/v1/submissions";
	private static String authorization = TestUser.getBase64Credentials();

	private Submission Setup() {
		Submission newSubmission = new Submission();
	    newSubmission.setBdeName("Jane Doe");
	    newSubmission.setPositionTitle("Senior Developer");
	    newSubmission.setBillRate(60.0);
	    newSubmission.setBillRateAnnual(120000.0);
	    newSubmission.setSubmissionStatus("Pending");
	    newSubmission.setDateOfSubmission(new Date());
	    newSubmission.setProjectStartDate("New Date");
	    newSubmission.setProjectEndDate("New Time");
	    newSubmission.setRemarks("Excellent candidate with strong skills");


	    testCandidate = new CandidateDetails();
        testCandidate.setCandidateId("CAND123");
        candidateDetailsRepository.save(testCandidate);
	    
		Vendor testVendor = new Vendor();
		testVendor.setVendorName("Vendor Corp");
		testVendor.setSpoc("spoc");
		testVendor.setVendorName("walmart");
		testVendor.setCity("Los Angels");
		testVendor.setState("CA");
		testVendor.setEmail("123@gmail.com");
		vendorRepository.save(testVendor);

		CustomerInterview testInterview = new CustomerInterview();
		testInterview.setInterviewDate("New Date");
		testInterview.setInterviewTime("New Time");
		testInterview.setInterviewResult("Positive");
		testInterview.setInterviewFeedback("Good technical skills");
	    
		EndClient testEndClient = new EndClient();
		testEndClient.setEndClient("Walmart");
		testEndClient.setCity("Los Angeles");
		endClientRepository.save(testEndClient);
		
		
		newSubmission.setCandidateDetails(testCandidate);
		newSubmission.setVendor(testVendor);
	    newSubmission.setEndClient(testEndClient);
	    newSubmission.setCustomerInterview(testInterview);

        return newSubmission;
    }



	@Test
	@Transactional
	public void testCreateSubmission() throws Exception {
		  Submission newSubmission = Setup();

	        String submissionJson = objectMapper.writeValueAsString(newSubmission);
	        submissionJson = submissionJson.replaceAll("\"id\":\\d+", "\"id\":null");

	        mockMvc.perform(post(resourceCall)
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(submissionJson)
	                .header("Authorization", authorization))
	                .andExpect(status().isOk());
	}
	@Test
    @Transactional
    public void testUpdateSubmission() throws Exception {
        // Create a submission for testing
        testSubmission = new Submission();
        testSubmission.setBdeName("John Doe");
        testSubmission.setPositionTitle("Junior Developer");
        testSubmission.setBillRate(40.0);
        testSubmission.setBillRateAnnual(80000.0);
        testSubmission.setSubmissionStatus("Submitted");
        testSubmission.setDateOfSubmission(new Date());
        testSubmission.setProjectStartDate("New Date");
        testSubmission.setProjectEndDate("New Time");
        testSubmission.setRemarks("Updated Remarks");

        String updatedSubmissionJson = objectMapper.writeValueAsString(testSubmission);
        updatedSubmissionJson = updatedSubmissionJson.replaceAll("\"id\":\\d+", "\"id\":null");

        // Perform a PUT request to update the submission
        mockMvc.perform(put(resourceCall + "/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedSubmissionJson)
                .header("Authorization", authorization))
                .andExpect(status().isOk());
    }

	@Test
	public void testDeleteSubmission() throws Exception {
		mockMvc.perform(delete(resourceCall + "/{id}", 1).header("Authorization", authorization))
				.andExpect(status().isOk());
	}
}

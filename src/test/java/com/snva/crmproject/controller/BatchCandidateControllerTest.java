package com.snva.crmproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.snva.crmproject.CrmProjectApplication;
import com.snva.crmproject.entity.batchDetails.Batch;
import com.snva.crmproject.entity.batchDetails.BatchCandidates;
import com.snva.crmproject.entity.batchDetails.BatchCandidatesId;
import com.snva.crmproject.entity.CandidateDetails;
import com.snva.crmproject.utility.TestUser;
import org.junit.jupiter.api.*;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = CrmProjectApplication.class)
@AutoConfigureMockMvc
public class BatchCandidateControllerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(BatchCandidateControllerTest.class);

	private static String authorization = TestUser.getBase64Credentials();

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testCreateBatchCandidate() throws Exception {
		LOGGER.info("Creating a batch candidate for testing");

		Date startDate = new Date();
		Batch batch = new Batch(2L, startDate, "regular", "upcoming");
		CandidateDetails candidate = new CandidateDetails("C124", null, 0, null, null, null, null, null, null, null,
				null, null, null, null, null, false, false, false, null);
		BatchCandidates batchCandidate = new BatchCandidates(batch, candidate);

		mockMvc.perform(post("/api/v1/batch-candidates").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(batchCandidate)).header("Authorization", authorization))
				.andExpect(status().isOk()).andExpect(jsonPath("$.batch.id").value(2L))
				.andExpect(jsonPath("$.candidate.candidateId").value("C124"));
	}

	@Test
	public void testGetBatchCandidateById() throws Exception {
		LOGGER.info("Getting a batch candidate for testing");

		Long batchCandidateId = 1L;

		mockMvc.perform(get("/api/v1/batch-candidates/{id}", batchCandidateId).header("Authorization", authorization))
				.andExpect(status().isOk());
		// .andExpect(jsonPath("$.id").value(batchCandidateId));
	}

	@Test
	public void testGetAllBatchCandidates() throws Exception {
		LOGGER.info("Getting all candidate for testing");

		mockMvc.perform(get("/api/v1/batch-candidates").header("Authorization", authorization))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray());
	}

	@Test
	public void testUpdateBatchCandidate() throws Exception {

		LOGGER.info("Updating a batch candidate for testing");

		Long batchCandidateId = 1L;
		Date startDate = new Date();
		Batch batch = new Batch(1L, startDate, "regular", "upcoming");
		CandidateDetails candidate = new CandidateDetails("C123", null, 0, null, null, null, null, null, null, null,
				null, null, null, null, null, false, false, false, null);
		BatchCandidates batchCandidate = new BatchCandidates(batch, candidate);

		mockMvc.perform(put("/api/v1/batch-candidates/{id}", batchCandidateId).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(batchCandidate)).header("Authorization", authorization))
				.andExpect(status().isOk()).andExpect(jsonPath("$.batch.id").value(1L))
				.andExpect(jsonPath("$.candidate.candidateId").value("C123"));
	}

	@Test
	public void testDeleteBatchCandidate() throws Exception {
		LOGGER.info("Deleting a batch candidate for testing");

		Long batchId = 2L;
		String candidateId = "C124";

		mockMvc.perform(delete("/api/v1/batch-candidates/{batchId}/{candidateId}", batchId, candidateId)
				.header("Authorization", authorization)).andExpect(status().isOk());
	}

}

package com.snva.crmproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.snva.crmproject.CrmProjectApplication;
import com.snva.crmproject.entity.CandidateBasicDetails;
import com.snva.crmproject.entity.batchDetails.Batch;
import com.snva.crmproject.entity.batchDetails.BatchCandidates;
import com.snva.crmproject.entity.CandidateDetails;
import com.snva.crmproject.repository.batch.BatchCandidatesRepository;
import com.snva.crmproject.repository.batch.BatchRepository;
import com.snva.crmproject.repository.candidate.CandidateBasicDetailsRepository;
import com.snva.crmproject.repository.candidate.CandidateDetailsRepository;
import com.snva.crmproject.utility.TestUser;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

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

    private static Batch testingBatch;
    private static BatchCandidates testingBatchCandidate;
    private static CandidateDetails testingCandidate;
    private static CandidateBasicDetails testingCandidateBD;
    private static String resourceCall = "/api/v1/batch-candidates";

    @Autowired
    private BatchRepository batchRepository;
    @Autowired
    private BatchCandidatesRepository batchCandidatesRepository;
    @Autowired
    private CandidateDetailsRepository candidateDetailsRepository;
    @Autowired
    private CandidateBasicDetailsRepository candidateRepository;

    @BeforeEach
    public void setup() {
            testingCandidateBD = new CandidateBasicDetails();
            testingCandidateBD.setCandidateId("SDPTEST01");
            testingCandidateBD.setFirstName("John");
            candidateRepository.save(testingCandidateBD);

            testingCandidate = new CandidateDetails();
            testingCandidate.setCandidateId(testingCandidateBD.getCandidateId());
            testingCandidate.setAddressCity("test city");

            testingCandidateBD.setDetails(testingCandidate);
            testingCandidate.setCandidateBasicDetails(testingCandidateBD);
            candidateRepository.save(testingCandidateBD);

            testingBatch = new Batch();
            testingBatch.setBatchType("test type");
            testingBatch.setStatus("test status");
            testingBatch.setStartDate(new Date());
            batchRepository.save(testingBatch);

            testingBatchCandidate = new BatchCandidates(testingBatch, testingCandidate);
            batchCandidatesRepository.save(testingBatchCandidate);
    }

    @AfterEach
    public void cleanup() {
        batchCandidatesRepository.delete(testingBatchCandidate);
        batchRepository.delete(testingBatch);
        candidateRepository.delete(testingCandidateBD);
    }

    @Test
    public void testCreateBatchCandidate() throws Exception {
        //removing batch candidate that we created in preparation phase
        batchCandidatesRepository.delete(testingBatchCandidate);

        LOGGER.info("Creating a batch candidate for testing");
        BatchCandidates batchCandidate = new BatchCandidates(testingBatch, testingCandidate);
        mockMvc.perform(post(resourceCall).contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(batchCandidate)).header("Authorization", authorization))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.batch.id").value(testingBatch.getId()))
                .andExpect(jsonPath("$.candidate.candidateId").value(testingCandidate.getCandidateId()));
    }

    @Test
    public void testGetBatchCandidatesByBatchId() throws Exception {
        LOGGER.info("Getting a batch candidate for testing");
        BatchCandidates batchCandidate = new BatchCandidates(testingBatch, testingCandidate);
        batchCandidatesRepository.save(batchCandidate);

        mockMvc.perform(get(resourceCall + "/{id}", testingBatch.getId()).header("Authorization", authorization))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(Matchers.greaterThan(0)));

        batchCandidatesRepository.delete(batchCandidate);
    }

    @Test
    public void testGetAllBatchCandidates() throws Exception {
        LOGGER.info("Getting all candidate for testing");
        mockMvc.perform(get(resourceCall).header("Authorization", authorization))
                .andExpect(status().isOk()).andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(Matchers.greaterThan(0)));
    }

    @Test
    public void testUpdateBatchCandidate() throws Exception {

        LOGGER.info("Updating a batch candidate for testing");
        BatchCandidates batchCandidate = new BatchCandidates(testingBatch, testingCandidate);

        mockMvc.perform(put(resourceCall + "/{id}", testingBatch.getId()).contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(batchCandidate)).header("Authorization", authorization))
                .andExpect(status().isOk()).andExpect(jsonPath("$.batch.id").value(testingBatch.getId()))
                .andExpect(jsonPath("$.candidate.candidateId").value(testingCandidate.getCandidateId()));
    }

    @Test
    public void testDeleteBatchCandidate() throws Exception {
        LOGGER.info("Deleting a batch candidate for testing");

        mockMvc.perform(delete(resourceCall+"/{batchId}/{candidateId}", testingBatch.getId(),testingCandidate.getCandidateId())
                .header("Authorization", authorization)).andExpect(status().isOk());
    }

}

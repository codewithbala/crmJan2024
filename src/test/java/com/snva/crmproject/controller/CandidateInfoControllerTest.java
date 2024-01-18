package com.snva.crmproject.controller;

import com.snva.crmproject.entity.CandidateBasicDetails;
import com.snva.crmproject.service.CandidateBasicDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CandidateInfoControllerTest {

    @Mock
    private CandidateBasicDetailsService candidateBasicDetailsService;

    @InjectMocks
    private CandidateInfoController candidateInfoController;

    private CandidateBasicDetails candidate;

    @BeforeEach
    void setUp() {
        candidate = new CandidateBasicDetails();
        candidate.setCandidateId("123");
        candidate.setFirstName("jean");
        candidate.setMiddleName("Jesse");
        candidate.setLastName("Joe");
        candidate.setRecruiterName("Willy");
        candidate.setEmail("jean@miu.edu");
        candidate.setPhoneNumber("641-788-9865");
        candidate.setWorkExperience("6");
        candidate.setVisaStatus("GC");
        candidate.setSsn("999-99-9999");
        candidate.setSchool("MIU");
        candidate.setDegree("master");
    }
    // Test for getting all candidates
    @Test
    public void testGetAllCandidates() {
        when(candidateBasicDetailsService.findAll()).thenReturn(Arrays.asList(candidate));

        ResponseEntity<List<CandidateBasicDetails>> response = candidateInfoController.getAllCandidates();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(candidateBasicDetailsService, times(1)).findAll();
    }
    // Test for getting a candidate by ID
    @Test
    public void testGetCandidateById() {
        when(candidateBasicDetailsService.findById(anyString())).thenReturn(candidate);

        ResponseEntity<CandidateBasicDetails> response = candidateInfoController.getCandidateById("123");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(candidate, response.getBody());
        verify(candidateBasicDetailsService, times(1)).findById("123");
    }
    // Test for updating a new candidate
    @Test
    public void testUpdateCandidate() {
        CandidateBasicDetails updatedCandidate = new CandidateBasicDetails();
        updatedCandidate.setCandidateId("123");
        updatedCandidate.setFirstName("Mark");

        when(candidateBasicDetailsService.update(any(CandidateBasicDetails.class))).thenReturn(updatedCandidate);

        ResponseEntity<CandidateBasicDetails> response = candidateInfoController.updateCandidate(updatedCandidate);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedCandidate, response.getBody());
        verify(candidateBasicDetailsService, times(1)).update(updatedCandidate);
    }

    // Test for adding a new candidate
    @Test
    public void testAddCandidate() {
        when(candidateBasicDetailsService.add(any(CandidateBasicDetails.class))).thenReturn(candidate);

        ResponseEntity<CandidateBasicDetails> response = candidateInfoController.addCandidate(candidate);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(candidate, response.getBody());
        verify(candidateBasicDetailsService, times(1)).add(candidate);
    }

    // Test for deleting a candidate
    @Test
    public void testDeleteCandidate() {
        doNothing().when(candidateBasicDetailsService).delete(anyString());

        ResponseEntity<String> response = candidateInfoController.deleteCandidate("123");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Candidate deleted successfully", response.getBody());
        verify(candidateBasicDetailsService, times(1)).delete("123");
    }
}



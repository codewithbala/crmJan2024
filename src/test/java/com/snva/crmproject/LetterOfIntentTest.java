package com.snva.crmproject.letterOfIntent;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import com.snva.crmproject.entity.LetterOfIntent;
import com.snva.crmproject.repository.candidate.LetterOfIntentRepository;
import com.snva.crmproject.service.LetterOfIntentService;

public class LetterOfIntentTest {
	@Mock
    private LetterOfIntentRepository LetterOfIntentRepository;

    @InjectMocks
    private LetterOfIntentService LetterOfIntentService;

    @SuppressWarnings("deprecation")
	@Test
    void testUpdateLetterOfIntent() {
       
        LetterOfIntent existingDetails = new LetterOfIntent();
        existingDetails.setId(1L);
        existingDetails.setCandidateId("123");
        existingDetails.setlOISent(true);
        existingDetails.setlOIAccepted(false);
        existingDetails.setJoinedBatch(true);
        existingDetails.setStartDate("2022-01-01");

        LetterOfIntent updatedDetails = new LetterOfIntent();
        updatedDetails.setCandidateId("456");
        updatedDetails.setlOISent(false);
        updatedDetails.setlOIAccepted(true);
        updatedDetails.setJoinedBatch(false);
        updatedDetails.setStartDate("2022-02-02");

        Mockito.when(LetterOfIntentRepository.findById(1L)).thenReturn(Optional.of(existingDetails));

       
        ResponseEntity<String> response = LetterOfIntentService.updateLetterOfIntent(1L, updatedDetails);

       
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo("Letter of Intent Details updated successfully");
        assertThat(existingDetails.getCandidateId()).isEqualTo("456");
        assertThat(existingDetails.islOISent()).isFalse();
        assertThat(existingDetails.islOIAccepted()).isTrue();
        assertThat(existingDetails.isJoinedBatch()).isFalse();
        assertThat(existingDetails.getStartDate()).isEqualTo("2022-02-02");
    }
}



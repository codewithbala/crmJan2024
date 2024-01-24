package com.snva.crmproject.controller;

import com.snva.crmproject.entity.customerInterview.CustomerInterview;
import com.snva.crmproject.service.CustomerInterviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
public class CustomerInterviewControllerTest {

        @Mock
        private CustomerInterviewService customerInterviewService;

        @InjectMocks
        private CustomerInterviewController customerInterviewController;

        private CustomerInterview existingInterview;
        private CustomerInterview updatedInterview;
        private final Long interviewId = 123L;
        private CustomerInterview interview;
        @BeforeEach
        void setUp() {
            existingInterview = new CustomerInterview();
            existingInterview.setInterviewID(interviewId);
            existingInterview.setInterviewDate(new Date());
            existingInterview.setInterviewTime(new Date());
            existingInterview.setInterviewResult("Passed");
            existingInterview.setInterviewFeedback("Excellent");

            updatedInterview = new CustomerInterview();
            updatedInterview.setInterviewID(interviewId);
            updatedInterview.setInterviewDate(new Date());
            updatedInterview.setInterviewTime(new Date());
            updatedInterview.setInterviewResult("Failed");
            updatedInterview.setInterviewFeedback("Needs improvement");

        }

    @Test
    void testAddInterview() {
        given(customerInterviewService.saveNewInterview(any(CustomerInterview.class))).willReturn(existingInterview);

        ResponseEntity<CustomerInterview> response = customerInterviewController.createInterview(existingInterview);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(existingInterview, response.getBody());

        verify(customerInterviewService).saveNewInterview(any(CustomerInterview.class));
    }
    @Test
    void testGetInterviewById() {
        given(customerInterviewService.findByInterviewId(interviewId)).willReturn(Optional.of(existingInterview));

        ResponseEntity<CustomerInterview> response = customerInterviewController.getInterviewById(interviewId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(existingInterview, response.getBody());

        verify(customerInterviewService).findByInterviewId(interviewId);
    }


    @Test
        void testUpdateInterview() {
        given(customerInterviewService.findByInterviewId(interviewId)).willReturn(Optional.of(existingInterview));
        given(customerInterviewService.saveNewInterview(any(CustomerInterview.class))).willReturn(updatedInterview);

        ResponseEntity<CustomerInterview> response = customerInterviewController.updateInterview(interviewId, updatedInterview);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(updatedInterview, response.getBody());

        verify(customerInterviewService).findByInterviewId(interviewId);
        verify(customerInterviewService).saveNewInterview(any(CustomerInterview.class));
        }


        @Test
        void testUpdateInterview_NotFound() {
            given(customerInterviewService.findByInterviewId(interviewId)).willReturn(Optional.empty());

            ResponseEntity<CustomerInterview> response = customerInterviewController.updateInterview(interviewId, updatedInterview);

            assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
            verify(customerInterviewService).findByInterviewId(interviewId);
            verify(customerInterviewService, never()).saveNewInterview(any(CustomerInterview.class));
        }

    @Test
    void testDeleteInterview() {
        given(customerInterviewService.findByInterviewId(interviewId)).willReturn(Optional.of(existingInterview));

        ResponseEntity<Void> response = customerInterviewController.deleteInterview(interviewId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

        verify(customerInterviewService).deleteByInterviewId(interviewId);
    }

}

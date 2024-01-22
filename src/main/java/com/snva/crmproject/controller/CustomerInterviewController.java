package com.snva.crmproject.controller;

import com.snva.crmproject.entity.customerInterview.CustomerInterview;
import com.snva.crmproject.service.CustomerInterviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins="${fontEnd.origins}")
@RequestMapping("/api/v1/customerInterviews")
public class CustomerInterviewController {

    private static  final Logger logger = LoggerFactory.getLogger(CustomerInterviewController.class);

    private  final CustomerInterviewService customerInterviewService;
    @Autowired
    public CustomerInterviewController(CustomerInterviewService customerInterviewService) {
        this.customerInterviewService = customerInterviewService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerInterview>> getAllInterviews() {
        return new ResponseEntity<>(customerInterviewService.findAllInterviews(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerInterview> getInterviewById(@PathVariable String id) {
        return customerInterviewService.findByInterviewId(id)
                .map(interview -> new ResponseEntity<>(interview, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CustomerInterview> createInterview(@RequestBody CustomerInterview customerInterview) {
        CustomerInterview savedInterview = customerInterviewService.saveNewInterview(customerInterview);
        return new ResponseEntity<>(savedInterview, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CustomerInterview> updateInterview(@PathVariable String id, @RequestBody CustomerInterview customerInterview) {
        return customerInterviewService.findByInterviewId(id)
                .map(existingInterview -> {
                    customerInterview.setInterviewID(id);
                    return new ResponseEntity<>(customerInterviewService.saveNewInterview(customerInterview), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInterview(@PathVariable String id) {
        if (!customerInterviewService.findByInterviewId(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerInterviewService.deleteByInterviewId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

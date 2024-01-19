package com.snva.crmproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snva.crmproject.entity.TechInterview;
import com.snva.crmproject.service.TechInterviewService;

@RestController
@RequestMapping("/api/v1/tech-interviews")
public class TechInterviewController {
	private static final Logger logger = LoggerFactory.getLogger(TechInterviewController.class);

	
	    @Autowired
	    private TechInterviewService techInterviewService;

	    @GetMapping
	    public ResponseEntity<List<TechInterview>> getAllTechInterviews() {
	    	logger.info("Request to get all tech interviews");
	        List<TechInterview> techInterviews = techInterviewService.getAllTechInterviews();
	        return new ResponseEntity<>(techInterviews, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<TechInterview> getTechInterviewById(@PathVariable Long id) {
	    	 logger.info("Request to get tech interview by ID: {}", id);
	        TechInterview techInterview = techInterviewService.getTechInterviewById(id);
	        if (techInterview != null) {
	            return new ResponseEntity<>(techInterview, HttpStatus.OK);
	        } else {
	        	logger.warn("Tech interview not found with ID: {}", id);
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PostMapping
	    public ResponseEntity<TechInterview> createTechInterview(@RequestBody TechInterview techInterview) {
	    	 logger.info("Request to create a new tech interview");
	        TechInterview createdInterview = techInterviewService.createTechInterview(techInterview);
	        logger.info("Tech interview created with ID: {}", createdInterview.getId());
	        return new ResponseEntity<>(createdInterview, HttpStatus.CREATED);
	    }


	    @PutMapping("/{id}")
	    public ResponseEntity<TechInterview> updateTechInterview(@PathVariable Long id, @RequestBody TechInterview updatedInterview) {
	    	 logger.info("Request to update tech interview with ID: {}", id);
	        TechInterview updated = techInterviewService.updateTechInterview(id, updatedInterview);
	        if (updated != null) {
	        	  logger.info("Tech interview updated successfully with ID: {}", id);
	            return new ResponseEntity<>(updated, HttpStatus.OK);
	        } else {
	        	  logger.warn("Tech interview not found for update with ID: {}", id);
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteTechInterview(@PathVariable Long id) {
	    	logger.info("Request to delete tech interview with ID: {}", id);
	        techInterviewService.deleteTechInterview(id);
	        logger.info("Tech interview deleted successfully with ID: {}", id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	

}
	    
	
	
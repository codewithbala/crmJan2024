package com.snva.crmproject.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snva.crmproject.entity.LetterOfIntent;
import com.snva.crmproject.service.LetterOfIntentService;

@RestController
@CrossOrigin(origins = "${fontEnd.origins}")
@RequestMapping("/api/v1/letter-of-intent")
public class LetterOfIntentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LetterOfIntentController.class);

	@Autowired
	private LetterOfIntentService letterOfIntentService;

	@GetMapping
	public List<LetterOfIntent> getAllLettersOfIntent() {
		LOGGER.info("Getting all Letters of Intent");
		return letterOfIntentService.getAllLettersOfIntent();
	}

	@GetMapping("/{id}")
	public Optional<LetterOfIntent> getLetterOfIntentById(@PathVariable Long id) {
		LOGGER.info("Getting Letter of Intent by ID: {}", id);
		return letterOfIntentService.getLetterOfIntentById(id);
	}

	@PostMapping
	public LetterOfIntent saveLetterOfIntent(@RequestBody LetterOfIntent letterOfIntent) {
		LOGGER.info("Saving Letter of Intent");
		return letterOfIntentService.saveLetterOfIntent(letterOfIntent);
	}

	@DeleteMapping("/{id}")
	public void deleteLetterOfIntent(@PathVariable Long id) {
		LOGGER.info("Deleting Letter of Intent by ID: {}", id);
		letterOfIntentService.deleteLetterOfIntent(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateLetterOfIntent(@PathVariable Long id,@RequestBody LetterOfIntent updatedLetterOfIntent) {
		LOGGER.info("Updating Letter of Intent with ID: {}", id);
		ResponseEntity<String> response = letterOfIntentService.updateLetterOfIntent(id, updatedLetterOfIntent);
		return response;
	}

}

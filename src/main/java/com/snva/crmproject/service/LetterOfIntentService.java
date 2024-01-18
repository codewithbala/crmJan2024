package com.snva.crmproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.snva.crmproject.entity.LetterOfIntent;
import com.snva.crmproject.repository.candidate.LetterOfIntentRepository;

@Service
public class LetterOfIntentService {

	@Autowired
	private LetterOfIntentRepository letterOfIntentRepository;

	public List<LetterOfIntent> getAllLettersOfIntent() {
		return letterOfIntentRepository.findAll();
	}

	public Optional<LetterOfIntent> getLetterOfIntentById(Long id) {
		return letterOfIntentRepository.findById(id);
	}

	public LetterOfIntent saveLetterOfIntent(LetterOfIntent letterOfIntent) {
		return letterOfIntentRepository.save(letterOfIntent);
	}

	public void deleteLetterOfIntent(Long id) {
		letterOfIntentRepository.deleteById(id);
	}

	public ResponseEntity<String> updateLetterOfIntent(Long id, LetterOfIntent updatedLetterOfIntent) {
		Optional<LetterOfIntent> existingLetterOfIntent = letterOfIntentRepository.findById(id);
		if (existingLetterOfIntent.isPresent()) {
			LetterOfIntent letterOfIntent = existingLetterOfIntent.get();

			letterOfIntent.setCandidateId(updatedLetterOfIntent.getCandidateId());
			letterOfIntent.setlOISent(updatedLetterOfIntent.islOISent());
			letterOfIntent.setlOIAccepted(updatedLetterOfIntent.islOIAccepted());
			letterOfIntent.setJoinedBatch(updatedLetterOfIntent.isJoinedBatch());
			letterOfIntent.setStartDate(updatedLetterOfIntent.getStartDate());

			letterOfIntentRepository.save(letterOfIntent);

			return ResponseEntity.ok("Letter of Intent updated successfully");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}

package com.snva.crmproject.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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

		/*
		 * public void deleteLetterOfIntent(Long id) {
		 * letterOfIntentRepository.deleteById(id); }
		 */

		public void updateBDCandidate(LetterOfIntent letterOfIntent) {
			 
	        letterOfIntentRepository.save(letterOfIntent);
	    
		}
	}




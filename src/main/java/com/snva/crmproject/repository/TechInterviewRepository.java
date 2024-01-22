package com.snva.crmproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snva.crmproject.entity.TechInterview;

@Repository
public interface TechInterviewRepository extends JpaRepository<TechInterview, Long>{


	  Optional<TechInterview> findByCandidateDetailsCandidateId(String candidateId);

}

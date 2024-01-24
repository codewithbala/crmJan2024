package com.snva.crmproject.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "LetterOfIntent")
public class LetterOfIntent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "candidate_id")
	private String candidateId;

	private boolean lOISent;
	private boolean lOIAccepted;
	private boolean joinedBatch;
	private String startDate;

	@OneToOne(mappedBy = "letterOfIntent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private CandidateDetails candidateDetails;

	public LetterOfIntent() {
		super();
	}

	public LetterOfIntent(Long id, String candidateId, boolean lOISent, boolean lOIAccepted, boolean joinedBatch,
			String startDate, CandidateDetails candidateDetails) {
		super();
		this.id = id;
		this.candidateId = candidateId;
		this.lOISent = lOISent;
		this.lOIAccepted = lOIAccepted;
		this.joinedBatch = joinedBatch;
		this.startDate = startDate;
		this.candidateDetails = candidateDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public boolean islOISent() {
		return lOISent;
	}

	public void setlOISent(boolean lOISent) {
		this.lOISent = lOISent;
	}

	public boolean islOIAccepted() {
		return lOIAccepted;
	}

	public void setlOIAccepted(boolean lOIAccepted) {
		this.lOIAccepted = lOIAccepted;
	}

	public boolean isJoinedBatch() {
		return joinedBatch;
	}

	public void setJoinedBatch(boolean joinedBatch) {
		this.joinedBatch = joinedBatch;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public CandidateDetails getCandidateDetails() {
		return candidateDetails;
	}

	public void setCandidateDetails(CandidateDetails candidateDetails) {
		this.candidateDetails = candidateDetails;
	}

	@Override
	public String toString() {
		return "LetterOfIntent [id=" + id + ", candidateId=" + candidateId + ", lOISent=" + lOISent + ", lOIAccepted="
				+ lOIAccepted + ", joinedBatch=" + joinedBatch + ", startDate=" + startDate + ", candidateDetails="
				+ candidateDetails + "]";
	}

}
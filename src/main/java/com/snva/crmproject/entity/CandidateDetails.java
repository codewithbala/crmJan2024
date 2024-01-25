package com.snva.crmproject.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.snva.crmproject.entity.SubmissionDetails.Submission;
import com.snva.crmproject.entity.batchDetails.Batch;

import jakarta.persistence.*;

@Entity
@Table(name = "CandidateDetails")
@JsonIdentityInfo(
	    generator = ObjectIdGenerators.PropertyGenerator.class,
	    property = "candidateId"
	)
public class CandidateDetails {

    @Id
    private String candidateId;
    private String skillSet;
    private int communicationSkill;
    private String addressLine1;
    private String addressLine2;
    private String addressCity;
    private String addressState;
    private String addressCounty;
    private String addressZipCode;
    private String source;
    private String remarks;
    private String interviewDate;
    private String interviewer;
    private String interviewerFeedback;
    private String candidateInterviewStatus;
    private boolean lOISent;
    private boolean lOIAccepted;
    private boolean joinedBatch;
    private String startDate;

    @ManyToMany(mappedBy = "candidates", fetch = FetchType.EAGER)
    private Set<Batch> batches = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "tech_interview_id")
    private TechInterview techInterview;

    @OneToOne
    @JoinColumn(name = "loi_id")
    private LetterOfIntent letterOfIntent;

   
    public CandidateDetails() {
    }

    // Getters and setters for all fields

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "candidateId")
    @JsonBackReference
    private CandidateBasicDetails candidateBasicDetails;

	@Override
	public String toString() {
		return "CandidateDetails [candidateId=" + candidateId + ", skillSet=" + skillSet + ", communicationSkill="
				+ communicationSkill + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", addressCity=" + addressCity + ", addressState=" + addressState + ", addressCounty=" + addressCounty
				+ ", addressZipCode=" + addressZipCode + ", source=" + source + ", remarks=" + remarks
				+ ", interviewDate=" + interviewDate + ", interviewer=" + interviewer + ", interviewerFeedback="
				+ interviewerFeedback + ", candidateInterviewStatus=" + candidateInterviewStatus + ", lOISent="
				+ lOISent + ", lOIAccepted=" + lOIAccepted + ", joinedBatch=" + joinedBatch + ", startDate=" + startDate
				+ ", batches=" + batches + ", techInterview=" + techInterview + ", letterOfIntent=" + letterOfIntent
				 + ", candidateBasicDetails=" + candidateBasicDetails + "]";
	}

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public String getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}

	public int getCommunicationSkill() {
		return communicationSkill;
	}

	public void setCommunicationSkill(int communicationSkill) {
		this.communicationSkill = communicationSkill;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressCounty() {
		return addressCounty;
	}

	public void setAddressCounty(String addressCounty) {
		this.addressCounty = addressCounty;
	}

	public String getAddressZipCode() {
		return addressZipCode;
	}

	public void setAddressZipCode(String addressZipCode) {
		this.addressZipCode = addressZipCode;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(String interviewDate) {
		this.interviewDate = interviewDate;
	}

	public String getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}

	public String getInterviewerFeedback() {
		return interviewerFeedback;
	}

	public void setInterviewerFeedback(String interviewerFeedback) {
		this.interviewerFeedback = interviewerFeedback;
	}

	public String getCandidateInterviewStatus() {
		return candidateInterviewStatus;
	}

	public void setCandidateInterviewStatus(String candidateInterviewStatus) {
		this.candidateInterviewStatus = candidateInterviewStatus;
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

	public Set<Batch> getBatches() {
		return batches;
	}

	public void setBatches(Set<Batch> batches) {
		this.batches = batches;
	}

	public TechInterview getTechInterview() {
		return techInterview;
	}

	public void setTechInterview(TechInterview techInterview) {
		this.techInterview = techInterview;
	}

	public LetterOfIntent getLetterOfIntent() {
		return letterOfIntent;
	}

	public void setLetterOfIntent(LetterOfIntent letterOfIntent) {
		this.letterOfIntent = letterOfIntent;
	}


	public CandidateBasicDetails getCandidateBasicDetails() {
		return candidateBasicDetails;
	}

	public void setCandidateBasicDetails(CandidateBasicDetails candidateBasicDetails) {
		this.candidateBasicDetails = candidateBasicDetails;
	}

    // Getter and setter for candidateBasicDetails

  
}

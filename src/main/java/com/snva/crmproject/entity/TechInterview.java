package com.snva.crmproject.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class TechInterview {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Date interviewDate;
	    private String interviewer;
	    private String interviewerFeedback;
	    private String candidateInterviewStatus;

//	    @OneToOne(fetch = FetchType.LAZY)
//	    @JoinColumn(name = "candidate_id", unique = true)
//	    private CandidateBasicDetails candidateBasicDetails;
//
	    @OneToOne
	    @JoinColumn(name = "details_id")  
	    private CandidateBasicDetails candidateDetails; 
	    
//	    @OneToOne
//	    @JoinColumn(name = "tech_interview_id") 
//	    private TechInterview techInterview;
	    
	   
	    
	    TechInterview() {
	        
	    }

	    public TechInterview(Date interviewDate, String interviewer, String interviewerFeedback, String candidateInterviewStatus, CandidateBasicDetails candidateBasicDetails) {
	        this.interviewDate = interviewDate;
	        this.interviewer = interviewer;
	        this.interviewerFeedback = interviewerFeedback;
	        this.candidateInterviewStatus = candidateInterviewStatus;
	        this.candidateDetails = candidateBasicDetails;
	    }

	   

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Date getInterviewDate() {
	        return interviewDate;
	    }

	    public void setInterviewDate(Date interviewDate) {
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

	 
        public CandidateBasicDetails getCandidateBasicDetails() {
			return candidateDetails;
		}

		public void setCandidateBasicDetails(CandidateBasicDetails candidateBasicDetails) {
			this.candidateDetails = candidateBasicDetails;
		}

		@Override
	    public String toString() {
	        return "TechInterview{" +
	                "id=" + id +
	                ", interviewDate=" + interviewDate +
	                ", interviewer='" + interviewer + '\'' +
	                ", interviewerFeedback='" + interviewerFeedback + '\'' +
	                ", candidateInterviewStatus='" + candidateInterviewStatus + '\'' +
	                ", candidate=" + candidateDetails +
	                '}';
	    }

	   
	}

	

	




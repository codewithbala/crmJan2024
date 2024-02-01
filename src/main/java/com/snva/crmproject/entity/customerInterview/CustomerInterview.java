package com.snva.crmproject.entity.customerInterview;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.Date;

import com.snva.crmproject.entity.SubmissionDetails.Submission;

@Entity
@Table(name = "customer_interview")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "interviewID")
public class CustomerInterview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="InterviewID")
    private Long cInterviewID;

    public Long getcInterviewID() {
		return cInterviewID;
	}

	public void setcInterviewID(Long cInterviewID) {
		this.cInterviewID = cInterviewID;
	}

	@Column(name = "interview_date")
    
    private String interviewDate;

    @Column(name = "interview_time")
    
    private String interviewTime;

    @OneToOne(mappedBy = "customerInterview")
    private Submission submission;

    private String interviewResult;
    private String interviewFeedback;

    public CustomerInterview() {}

    public CustomerInterview(Long interviewID, String interviewDate, String interviewTime,
                             String interviewResult, String interviewFeedback) {
        this.cInterviewID = interviewID;
        this.interviewDate = interviewDate;
        this.interviewTime = interviewTime;
        this.interviewResult = interviewResult;
        this.interviewFeedback = interviewFeedback;
    }

    public Long getInterviewID() {
        return cInterviewID;
    }

    public void setInterviewID(Long interviewID) {
        this.cInterviewID = interviewID;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(String interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(String interviewTime) {
        this.interviewTime = interviewTime;
    }

    public String getInterviewResult() {
        return interviewResult;
    }

    public void setInterviewResult(String interviewResult) {
        this.interviewResult = interviewResult;
    }

    public String getInterviewFeedback() {
        return interviewFeedback;
    }

    public void setInterviewFeedback(String interviewFeedback) {
        this.interviewFeedback = interviewFeedback;
    }

    @Override
    public String toString() {
        return "CustomerInterview{" +
                "interviewID=" + cInterviewID +
                ", interviewDate=" + interviewDate +
                ", interviewTime=" + interviewTime +
                ", interviewResult='" + interviewResult + '\'' +
                ", interviewFeedback='" + interviewFeedback + '\'' +
                '}';
    }
}

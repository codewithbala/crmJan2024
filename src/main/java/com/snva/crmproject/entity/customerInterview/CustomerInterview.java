package com.snva.crmproject.entity.customerInterview;


import jakarta.persistence.*;

import java.util.Date;

import com.snva.crmproject.entity.SubmissionDetails.Submission;

@Entity
@Table(name = "customer_interview")
public class CustomerInterview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interviewID;

    @Column(name = "interview_date")
    @Temporal(TemporalType.DATE)
    private Date interviewDate;

    @Column(name = "interview_time")
    @Temporal(TemporalType.TIME)
    private Date interviewTime;

    
    @OneToOne(mappedBy = "customerInterview")
    private Submission submission;
    
    
    
    private String interviewResult;
    private String interviewFeedback;

    public CustomerInterview() {}

    public CustomerInterview(Long interviewID, Date interviewDate, Date interviewTime,
                             String interviewResult, String interviewFeedback) {
        this.interviewID = interviewID;
        this.interviewDate = interviewDate;
        this.interviewTime = interviewTime;
        this.interviewResult = interviewResult;
        this.interviewFeedback = interviewFeedback;
    }

    public Long getInterviewID() {
        return interviewID;
    }

    public void setInterviewID(Long interviewID) {
        this.interviewID = interviewID;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public Date getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(Date interviewTime) {
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
                "interviewID=" + interviewID +
                ", interviewDate=" + interviewDate +
                ", interviewTime=" + interviewTime +
                ", interviewResult='" + interviewResult + '\'' +
                ", interviewFeedback='" + interviewFeedback + '\'' +
                '}';
    }
}

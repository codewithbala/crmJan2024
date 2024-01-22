package com.snva.crmproject.entity.customerInterview;

import com.snva.crmproject.entity.CandidateBasicDetails;
import jakarta.persistence.*;

@Entity
@Table(name = "customer_interview")
public class CustomerInterview {
    @Id
    private String interviewID;
    private  String interviewDate;
    private String interviewTime;
    private String interviewResult;
    private  String interviewFeedback;


    public  CustomerInterview(){}
    public CustomerInterview(String interviewID, String interviewDate,
                             String interviewTime, String interviewResult,
                             String interviewFeedback) {
        this.interviewID = interviewID;
        this.interviewDate = interviewDate;
        this.interviewTime = interviewTime;
        this.interviewResult = interviewResult;
        this.interviewFeedback = interviewFeedback;
    }

    public String getInterviewID() {
        return interviewID;
    }

    public void setInterviewID(String interviewID) {
        this.interviewID = interviewID;
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
                "interviewID='" + interviewID + '\'' +
                ", interviewDate='" + interviewDate + '\'' +
                ", interviewTime='" + interviewTime + '\'' +
                ", interviewResult='" + interviewResult + '\'' +
                ", interviewFeedback='" + interviewFeedback + '\'' +
                '}';
    }
}

package com.snva.crmproject.entity.SubmissionDetails;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_of_submission", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfSubmission;

    @Column(name = "bde_name", nullable = false)
    private String bdeName;

    @Column(name = "position_title", nullable = false)
    private String positionTitle;

    @Column(name = "candidate_id")
    private Long candidateId; // Placeholder for Candidate entity

    @Column(name = "vendor_id")
    private Long vendorId; // Placeholder for Vendor entity

    @Column(name = "end_client_id")
    private Long endClientId; // Placeholder for EndClient entity

    @Column(name = "bill_rate")
    private double billRate;

    @Column(name = "bill_rate_annual")
    private double billRateAnnual;

    @Column(name = "submission_status", nullable = false)
    private String submissionStatus;

    @Column(name = "interview_id")
    private Long interviewId; // Placeholder for CustomerInterview entity

    @Column(name = "project_start_date")
    @Temporal(TemporalType.DATE)
    private Date projectStartDate;

    @Column(name = "project_end_date")
    @Temporal(TemporalType.DATE)
    private Date projectEndDate;

    @Column(name = "remarks")
    private String remarks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateOfSubmission() {
		return dateOfSubmission;
	}

	public void setDateOfSubmission(Date dateOfSubmission) {
		this.dateOfSubmission = dateOfSubmission;
	}

	public String getBdeName() {
		return bdeName;
	}

	public void setBdeName(String bdeName) {
		this.bdeName = bdeName;
	}

	public String getPositionTitle() {
		return positionTitle;
	}

	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public Long getEndClientId() {
		return endClientId;
	}

	public void setEndClientId(Long endClientId) {
		this.endClientId = endClientId;
	}

	public double getBillRate() {
		return billRate;
	}

	public void setBillRate(double billRate) {
		this.billRate = billRate;
	}

	public double getBillRateAnnual() {
		return billRateAnnual;
	}

	public void setBillRateAnnual(double billRateAnnual) {
		this.billRateAnnual = billRateAnnual;
	}

	public String getSubmissionStatus() {
		return submissionStatus;
	}

	public void setSubmissionStatus(String submissionStatus) {
		this.submissionStatus = submissionStatus;
	}

	public Long getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Long interviewId) {
		this.interviewId = interviewId;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
	public Submission() {

    }
	public Submission(Long id, Date dateOfSubmission, String bdeName, String positionTitle, Long candidateId,
			Long vendorId, Long endClientId, double billRate, double billRateAnnual, String submissionStatus,
			Long interviewId, Date projectStartDate, Date projectEndDate, String remarks) {
		super();
		this.id = id;
		this.dateOfSubmission = dateOfSubmission;
		this.bdeName = bdeName;
		this.positionTitle = positionTitle;
		this.candidateId = candidateId;
		this.vendorId = vendorId;
		this.endClientId = endClientId;
		this.billRate = billRate;
		this.billRateAnnual = billRateAnnual;
		this.submissionStatus = submissionStatus;
		this.interviewId = interviewId;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.remarks = remarks;
	}
	 public String toString() {
	        return "Submission{" +
	                "id=" + id +
	                ", dateOfSubmission=" + dateOfSubmission +
	                ", bdeName='" + bdeName + '\'' +
	                ", positionTitle='" + positionTitle + '\'' +
	                ", candidateId=" + candidateId +
	                ", vendorId=" + vendorId +
	                ", endClientId=" + endClientId +
	                ", billRate=" + billRate +
	                ", billRateAnnual=" + billRateAnnual +
	                ", submissionStatus='" + submissionStatus + '\'' +
	                ", interviewId=" + interviewId +
	                ", projectStartDate=" + projectStartDate +
	                ", projectEndDate=" + projectEndDate +
	                ", remarks='" + remarks + '\'' +
	                '}';
	    }

   
}

package com.snva.crmproject.entity.SubmissionDetails;

import java.util.Date;

import com.snva.crmproject.entity.CandidateDetails;
import com.snva.crmproject.entity.EndClient;
import com.snva.crmproject.entity.Vendor;
import com.snva.crmproject.entity.customerInterview.CustomerInterview;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "candidate_id")
    private CandidateDetails candidateDetails;  //One to One mapping to Candidate Detail Entity

    
    @Column(name = "date_of_submission", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfSubmission;

    @Column(name = "bde_name", nullable = false)
    private String bdeName;

    @Column(name = "position_title", nullable = false)
    private String positionTitle;

   
    @OneToOne
    @JoinColumn(name = "id")
    private Vendor vendor; ///One to One mapping to Vendor Entity.

    
    @OneToOne
    @JoinColumn(name = "id")
    private EndClient endClient;  //One to One mapping to end client Entity.

    @Column(name = "bill_rate")
    private double billRate;

    @Column(name = "bill_rate_annual")
    private double billRateAnnual;

    @Column(name = "submission_status", nullable = false)
    private String submissionStatus;

    @OneToOne
    @JoinColumn(name = "id")
    private CustomerInterview customerInterview; //One to One mapping to interview ID Entity.


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

	 public CustomerInterview getCustomerInterview() {
	        return customerInterview;
	    }

	    public void setCustomerInterview(CustomerInterview customerInterview) {
	        this.customerInterview = customerInterview;
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

	
	public EndClient getEndClient() {
		return endClient;
	}

	public void setEndClient(EndClient endClient) {
		this.endClient = endClient;
	}

	public Submission() {

    }
	
	 public CandidateDetails getCandidateDetails() {
	        return candidateDetails;
	    }

	    public void setCandidateDetails(CandidateDetails candidateDetails) {
	        this.candidateDetails = candidateDetails;
	    }

		public Vendor getVendor() {
			return vendor;
		}

		public void setVendor(Vendor vendor) {
			this.vendor = vendor;
		}

		public Submission(Long id, CandidateDetails candidateDetails, Date dateOfSubmission, String bdeName,
				String positionTitle, Vendor vendor, EndClient endClient, double billRate, double billRateAnnual,
				String submissionStatus, CustomerInterview customerInterview, Date projectStartDate,
				Date projectEndDate, String remarks) {
			super();
			this.id = id;
			this.candidateDetails = candidateDetails;
			this.dateOfSubmission = dateOfSubmission;
			this.bdeName = bdeName;
			this.positionTitle = positionTitle;
			this.vendor = vendor;
			this.endClient = endClient;
			this.billRate = billRate;
			this.billRateAnnual = billRateAnnual;
			this.submissionStatus = submissionStatus;
			this.customerInterview = customerInterview;
			this.projectStartDate = projectStartDate;
			this.projectEndDate = projectEndDate;
			this.remarks = remarks;
		}

		@Override
		public String toString() {
			return "Submission [id=" + id + ", candidateDetails=" + candidateDetails + ", dateOfSubmission="
					+ dateOfSubmission + ", bdeName=" + bdeName + ", positionTitle=" + positionTitle + ", vendor="
					+ vendor + ", endClient=" + endClient + ", billRate=" + billRate + ", billRateAnnual="
					+ billRateAnnual + ", submissionStatus=" + submissionStatus + ", customerInterview="
					+ customerInterview + ", projectStartDate=" + projectStartDate + ", projectEndDate="
					+ projectEndDate + ", remarks=" + remarks + "]";
		}

		

	
}

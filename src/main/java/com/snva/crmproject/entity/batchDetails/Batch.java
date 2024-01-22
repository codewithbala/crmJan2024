package com.snva.crmproject.entity.batchDetails;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.snva.crmproject.entity.CandidateDetails;

import jakarta.persistence.*;


import lombok.Data;

@Data

@Entity
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "batch_type", nullable = false)
    private String batchType; // 'regular' or 'fast'

    @Column(name = "status", nullable = false)
    private String status; // 'upcoming', 'in progress', 'completed'


    @ManyToMany
    @JoinTable(
        name = "batch_candidates",
        joinColumns = @JoinColumn(name = "batch_id"),
        inverseJoinColumns = @JoinColumn(name = "candidate_id")
    )
    private Set<CandidateDetails> candidates = new HashSet<>();

	public Batch() {

    }

    public Batch(Long id, Date startDate, String batchType, String status) {
        super();
        this.id = id;
        this.startDate = startDate;
        this.batchType = batchType;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getBatchType() {
        return batchType;
    }

    public void setBatchType(String batchType) {
        this.batchType = batchType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


	
	   @Override
		public String toString() {
			return "Batch [id=" + id + ", startDate=" + startDate + ", batchType=" + batchType + ", status=" + status + "]";
		}
   public void setCandidates(Set<CandidateDetails> candidates) {
        this.candidates = candidates;
    }

	
	

}

package com.snva.crmproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CandidateAttachments")
public class CandidateAttachments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long attachmentId;
	private String candidateId;
	private boolean isResume;
	private String attachment;
	

	public Long getAttachmentId() {
		return attachmentId;
	}


	public void setAttachmentId(Long attachmentId) {
		this.attachmentId = attachmentId;
	}





	public String getCandidateId() {
		return candidateId;
	}





	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}





	public boolean isResume() {
		return isResume;
	}





	public void setResume(boolean isResume) {
		this.isResume = isResume;
	}





	public String getAttachment() {
		return attachment;
	}





	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}





	public CandidateAttachments() {
		super();
		// TODO Auto-generated constructor stub
	}





	public CandidateAttachments(Long attachmentId, String candidateId, boolean isResume, String attachment) {
		super();
		this.attachmentId = attachmentId;
		this.candidateId = candidateId;
		this.isResume = isResume;
		this.attachment = attachment;
	}





	@Override
	public String toString() {
		return "CandidateAttachments [attachmentId=" + attachmentId + ", candidateId=" + candidateId + ", isResume="
				+ isResume + ", attachement=" + attachment + ", candidateBasicDetails=" + " " + "]";
	}
	
	


}
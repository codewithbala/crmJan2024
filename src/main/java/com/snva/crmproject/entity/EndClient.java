package com.snva.crmproject.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.snva.crmproject.entity.SubmissionDetails.Submission;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EndClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long endClientId;

    public Long getEndClientId() {
		return endClientId;
	}

	public void setEndClientId(Long endClientId) {
		this.endClientId = endClientId;
	}

	private String endClient;
    private String city;
    private String state;

    @OneToOne(mappedBy = "endClient")
	private Submission submission;

	public EndClient() {

    }

	public Long getId() {
		return endClientId;
	}

	public void setId(Long id) {
		this.endClientId = id;
	}

	public String getEndClient() {
		return endClient;
	}

	public void setEndClient(String endClient) {
		this.endClient = endClient;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public EndClient(Long id, String endClient, String city, String state) {
		super();
		this.endClientId = id;
		this.endClient = endClient;
		this.city = city;
		this.state = state;
	}

	@Override
	public String toString() {
		return "EndClient [id=" + endClientId + ", endClient=" + endClient + ", city=" + city + ", state=" + state
				+ ", submission=" + submission + "]";
	}

}

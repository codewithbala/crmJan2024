package com.snva.crmproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class EndClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String endClient;
    private String city;
    private String state;

	public EndClient() {

    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		this.id = id;
		this.endClient = endClient;
		this.city = city;
		this.state = state;
	}

}

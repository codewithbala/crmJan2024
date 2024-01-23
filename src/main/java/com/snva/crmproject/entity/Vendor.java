package com.snva.crmproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Vendor {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String vendorTier;
	    private String vendorName;
	    private String spoc;
	    private String poc;
	    private String email;
	    private String phone;
	    private String state;
	    private String city;
		public Vendor(Long id, String vendorTier, String vendorName, String spoc, String poc, String email,
				String phone, String state, String city) {
			super();
			this.id = id;
			this.vendorTier = vendorTier;
			this.vendorName = vendorName;
			this.spoc = spoc;
			this.poc = poc;
			this.email = email;
			this.phone = phone;
			this.state = state;
			this.city = city;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getVendorTier() {
			return vendorTier;
		}
		public void setVendorTier(String vendorTier) {
			this.vendorTier = vendorTier;
		}
		public String getVendorName() {
			return vendorName;
		}
		public void setVendorName(String vendorName) {
			this.vendorName = vendorName;
		}
		public String getSpoc() {
			return spoc;
		}
		public void setSpoc(String spoc) {
			this.spoc = spoc;
		}
		public String getPoc() {
			return poc;
		}
		public void setPoc(String poc) {
			this.poc = poc;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}   
	    
	}

	



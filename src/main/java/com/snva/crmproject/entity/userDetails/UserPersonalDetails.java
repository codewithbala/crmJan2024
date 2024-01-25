package com.snva.crmproject.entity.userDetails;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
public class UserPersonalDetails {

    @Id
    @Column(name = "user_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    private String firstName;

    private String lastName;

    private String phone;

    private String addressLine1;

    private String addressLine2;

    private String addressCity;

    private String addressState;

    private String addressCountry;

    private String addressZipCode;

    public UserPersonalDetails() {
    }

    public UserPersonalDetails(String firstName, String lastName, String phone, String address_Line1,
                               String address_Line2, String address_City, String address_State, String address_Country,
                               String address_ZipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.addressLine1 = address_Line1;
        this.addressLine2 = address_Line2;
        this.addressCity = address_City;
        this.addressState = address_State;
        this.addressCountry = address_Country;
        this.addressZipCode = address_ZipCode;
    }

    public UserPersonalDetails(String firstName, String lastName, String phone, String address_Line1,
                               String address_Line2, String address_City, String address_State, String address_Country,
                               String address_ZipCode, User user) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.addressLine1 = address_Line1;
        this.addressLine2 = address_Line2;
        this.addressCity = address_City;
        this.addressState = address_State;
        this.addressCountry = address_Country;
        this.addressZipCode = address_ZipCode;
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserPersonalDetails [firstName=" + firstName + ", lastName=" + lastName
                + ", phone=" + phone + ", address_Line1=" + addressLine1 + ", address_Line2=" + addressLine2
                + ", address_City=" + addressCity + ", address_State=" + addressState + ", address_Country="
                + addressCountry + ", address_ZipCode=" + addressZipCode + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public String getAddressZipCode() {
        return addressZipCode;
    }

    public void setAddressZipCode(String addressZipCode) {
        this.addressZipCode = addressZipCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

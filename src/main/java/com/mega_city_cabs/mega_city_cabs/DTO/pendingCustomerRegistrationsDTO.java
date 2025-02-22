package com.mega_city_cabs.mega_city_cabs.DTO;

import java.time.LocalDateTime;

public class pendingCustomerRegistrationsDTO {

    private String customerId;
    private String firstName;
    private String lastName;
    private String contact;
    private LocalDateTime requestedDate;

    public pendingCustomerRegistrationsDTO() {
    }

    public pendingCustomerRegistrationsDTO(String customerId, String firstName, String lastName, String contact, LocalDateTime requestedDate) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.requestedDate = requestedDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public LocalDateTime getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(LocalDateTime requestedDate) {
        this.requestedDate = requestedDate;
    }
}

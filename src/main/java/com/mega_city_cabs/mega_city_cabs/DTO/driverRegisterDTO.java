package com.mega_city_cabs.mega_city_cabs.DTO;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class driverRegisterDTO {

    private String firstName;
    private String lastName;
    private String contactNumber;
    private String nic;

    public driverRegisterDTO() {
    }

    public driverRegisterDTO(String firstName, String lastName, String contactNumber, String nic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.nic = nic;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
}

package com.mega_city_cabs.mega_city_cabs.DTO;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class driverUpdateDTO {

    private String driverId;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String nic;
    private LocalDateTime registeredDate;

    public driverUpdateDTO() {
    }

    public driverUpdateDTO(String driverId, String firstName, String lastName, String contactNumber, String nic, LocalDateTime registeredDate) {
        this.driverId = driverId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.nic = nic;
        this.registeredDate = registeredDate;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
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

    public LocalDateTime getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDateTime registeredDate) {
        this.registeredDate = registeredDate;
    }
}

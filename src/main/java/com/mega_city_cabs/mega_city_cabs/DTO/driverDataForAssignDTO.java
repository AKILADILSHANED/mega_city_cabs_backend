package com.mega_city_cabs.mega_city_cabs.DTO;

import jakarta.persistence.Column;

public class driverDataForAssign {
    private String driverId;
    private String firstName;
    private String lastName;

    public driverDataForAssign() {
    }

    public driverDataForAssign(String driverId, String firstName, String lastName) {
        this.driverId = driverId;
        this.firstName = firstName;
        this.lastName = lastName;
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
}

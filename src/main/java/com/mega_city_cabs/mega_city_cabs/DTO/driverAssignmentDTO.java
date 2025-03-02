package com.mega_city_cabs.mega_city_cabs.DTO;

import com.mega_city_cabs.mega_city_cabs.Entity.administrator;
import com.mega_city_cabs.mega_city_cabs.Entity.booking;
import com.mega_city_cabs.mega_city_cabs.Entity.driver;


import java.time.LocalDateTime;

public class driverAssignmentDTO {

    private String assignmentId;
    private LocalDateTime assignDate;
    private administrator assignedAdmin;
    private driver assignedDriver;
    private booking bookingId;

    public driverAssignmentDTO() {
    }

    public driverAssignmentDTO(String assignmentId, LocalDateTime assignDate, administrator assignedAdmin, driver assignedDriver, booking bookingId) {
        this.assignmentId = assignmentId;
        this.assignDate = assignDate;
        this.assignedAdmin = assignedAdmin;
        this.assignedDriver = assignedDriver;
        this.bookingId = bookingId;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public LocalDateTime getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(LocalDateTime assignDate) {
        this.assignDate = assignDate;
    }

    public administrator getAssignedAdmin() {
        return assignedAdmin;
    }

    public void setAssignedAdmin(administrator assignedAdmin) {
        this.assignedAdmin = assignedAdmin;
    }

    public driver getAssignedDriver() {
        return assignedDriver;
    }

    public void setAssignedDriver(driver assignedDriver) {
        this.assignedDriver = assignedDriver;
    }

    public booking getBookingId() {
        return bookingId;
    }

    public void setBookingId(booking bookingId) {
        this.bookingId = bookingId;
    }
}

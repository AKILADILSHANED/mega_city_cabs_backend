package com.mega_city_cabs.mega_city_cabs.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "driver_assignment")
public class DriverAssignment {

    @Id
    @Column(name = "Assignment_Id", length = 10, nullable = false)
    private String assignmentId;

    @Column(name = "Assignment_Date", nullable = false)
    private LocalDateTime assignDate;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private administrator assignedAdmin;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private driver assignedDriver;

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private booking bookingId;

    public DriverAssignment() {
    }

    public DriverAssignment(String assignmentId, LocalDateTime assignDate, administrator assignedAdmin, driver assignedDriver, booking bookingId) {
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

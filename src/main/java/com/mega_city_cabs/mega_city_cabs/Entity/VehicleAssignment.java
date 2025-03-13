package com.mega_city_cabs.mega_city_cabs.Entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Vehicle_Assignment")
public class VehicleAssignment {
    @Id
    @Column(name = "Assignment_Id", length = 10, nullable = false)
    private String assignmentId;
    @Column(name = "Assignment_Date", nullable = false)
    private LocalDateTime assignDate;
    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private administrator assignedAdmin;
    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private vehicle assignedVehicle;
    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private booking bookingId;

    public VehicleAssignment() {
    }

    public VehicleAssignment(String assignmentId, LocalDateTime assignDate, administrator assignedAdmin, vehicle assignedVehicle, booking bookingId) {
        this.assignmentId = assignmentId;
        this.assignDate = assignDate;
        this.assignedAdmin = assignedAdmin;
        this.assignedVehicle = assignedVehicle;
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
    public vehicle getAssignedVehicle() {
        return assignedVehicle;
    }
    public void setAssignedVehicle(vehicle assignedVehicle) {
        this.assignedVehicle = assignedVehicle;
    }
    public booking getBookingId() {
        return bookingId;
    }
    public void setBookingId(booking bookingId) {
        this.bookingId = bookingId;
    }
}

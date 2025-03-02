package com.mega_city_cabs.mega_city_cabs.DTO;

import com.mega_city_cabs.mega_city_cabs.Entity.vehicle;

public class checkBookingApprovalDTO {
    private String bookingId;
    private String assignmentId;
    private String assignmentIdVehicle;

    public checkBookingApprovalDTO() {
    }

    public checkBookingApprovalDTO(String bookingId, String assignmentId, String assignmentIdVehicle) {
        this.bookingId = bookingId;
        this.assignmentId = assignmentId;
        this.assignmentIdVehicle = assignmentIdVehicle;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getAssignmentIdVehicle() {
        return assignmentIdVehicle;
    }

    public void setAssignmentIdVehicle(String assignmentIdVehicle) {
        this.assignmentIdVehicle = assignmentIdVehicle;
    }
}

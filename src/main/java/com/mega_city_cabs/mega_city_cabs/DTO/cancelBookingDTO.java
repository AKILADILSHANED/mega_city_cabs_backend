package com.mega_city_cabs.mega_city_cabs.DTO;

import java.time.LocalDateTime;

public class cancelBookingDTO {

    private String bookingId;
    private String pickupLocation;
    private String destination;
    private LocalDateTime bookingDate;
    private String vehicleType;
    private String bookingType;
    private String message;

    public cancelBookingDTO() {
    }

    public cancelBookingDTO(String bookingId, String pickupLocation, String destination, LocalDateTime bookingDate, String vehicleType, String bookingType, String message) {
        this.bookingId = bookingId;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.bookingDate = bookingDate;
        this.vehicleType = vehicleType;
        this.bookingType = bookingType;
        this.message = message;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

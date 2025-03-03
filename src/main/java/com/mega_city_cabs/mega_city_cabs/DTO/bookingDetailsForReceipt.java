package com.mega_city_cabs.mega_city_cabs.DTO;


import java.time.LocalDateTime;

public class bookingDetailsForReceipt {
    private String bookingId;
    private LocalDateTime bookingDate;
    private String pickupLocation;
    private String destination;
    private String vehicleType;
    private String customerId;
    private String firstName;
    private String lastName;
    private int message;

    public bookingDetailsForReceipt() {
    }

    public bookingDetailsForReceipt(String bookingId, LocalDateTime bookingDate, String pickupLocation, String destination, String vehicleType, String customerId, String firstName, String lastName, int message) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.vehicleType = vehicleType;
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.message = message;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
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

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
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

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }
}

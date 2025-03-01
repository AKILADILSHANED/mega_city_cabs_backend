package com.mega_city_cabs.mega_city_cabs.DTO;

import java.time.LocalDateTime;

public class approveBookingDTO {

    private String bookingId;
    private LocalDateTime bookingDate;
    private String bookingType;
    private String pickupLocation;
    private String destination;
    private String vehicleNumber;
    private String firstName;
    private String first_name;
    private String last_name;
    private String contact;

    public approveBookingDTO() {
    }

    public approveBookingDTO(String bookingId, LocalDateTime bookingDate, String bookingType, String pickupLocation, String destination, String vehicleNumber, String firstName, String first_name, String last_name, String contact) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.bookingType = bookingType;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.vehicleNumber = vehicleNumber;
        this.firstName = firstName;
        this.first_name = first_name;
        this.last_name = last_name;
        this.contact = contact;
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

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
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

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

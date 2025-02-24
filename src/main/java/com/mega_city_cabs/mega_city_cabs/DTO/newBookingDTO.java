package com.mega_city_cabs.mega_city_cabs.DTO;


public class newBookingDTO {


    private String pickupLocation;
    private String destination;
    private String vehicleType;

    public newBookingDTO() {
    }

    public newBookingDTO(String pickupLocation, String destination, String vehicleType) {
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.vehicleType = vehicleType;
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
}

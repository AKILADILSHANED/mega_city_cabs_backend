package com.mega_city_cabs.mega_city_cabs.DTO;

public class vehicleDataForAssignDTO {
    private String vehicleId;
    private String vehicleNumber;

    public vehicleDataForAssignDTO() {
    }

    public vehicleDataForAssignDTO(String vehicleId, String vehicleNumber) {
        this.vehicleId = vehicleId;
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}

package com.mega_city_cabs.mega_city_cabs.DTO;

import org.springframework.stereotype.Component;

@Component
public class vehicleUpdateDTO {

    private String vehicleId;

    private String vehicleNumber;

    private String vehicleType;

    private String vehicleModel;

    public vehicleUpdateDTO() {
    }

    public vehicleUpdateDTO(String vehicleId, String vehicleNumber, String vehicleType, String vehicleModel) {
        this.vehicleId = vehicleId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
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

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
}

package com.mega_city_cabs.mega_city_cabs.DTO;

import org.springframework.stereotype.Component;

@Component
public class registerVehicleDTO {
    private String vehicleNumber;

    private String vehicleType;

    private String vehicleModel;

    public registerVehicleDTO() {
    }

    public registerVehicleDTO(String vehicleNumber, String vehicleType, String vehicleModel) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
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

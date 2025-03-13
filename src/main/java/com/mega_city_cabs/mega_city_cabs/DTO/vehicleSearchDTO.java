package com.mega_city_cabs.mega_city_cabs.DTO;

import com.mega_city_cabs.mega_city_cabs.Entity.administrator;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class vehicleSearchDTO {

    private String vehicleId;

    private String vehicleNumber;

    private String vehicleType;

    private String vehicleModel;

    private LocalDateTime registeredDate;

    private administrator Admin;

    private String message;

    public vehicleSearchDTO() {
    }

    public vehicleSearchDTO(String vehicleId, String vehicleNumber, String vehicleType, String vehicleModel, LocalDateTime registeredDate, administrator admin, String message) {
        this.vehicleId = vehicleId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.registeredDate = registeredDate;
        Admin = admin;
        this.message = message;
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

    public LocalDateTime getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDateTime registeredDate) {
        this.registeredDate = registeredDate;
    }

    public administrator getAdmin() {
        return Admin;
    }

    public void setAdmin(administrator admin) {
        Admin = admin;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

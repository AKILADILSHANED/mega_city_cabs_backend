package com.mega_city_cabs.mega_city_cabs.DTO;

import com.mega_city_cabs.mega_city_cabs.Entity.administrator;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class vehicleDTO {

    private String vehicleId;

    private String vehicleNumber;

    private String vehicleType;

    private String vehicleModel;

    private LocalDate registeredDate;

    private administrator Admin;

    public vehicleDTO() {
    }

    public vehicleDTO(String vehicleId, String vehicleNumber, String vehicleType, String vehicleModel, LocalDate registeredDate, administrator admin) {
        this.vehicleId = vehicleId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.registeredDate = registeredDate;
        Admin = admin;
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

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public administrator getAdmin() {
        return Admin;
    }

    public void setAdmin(administrator admin) {
        Admin = admin;
    }
}

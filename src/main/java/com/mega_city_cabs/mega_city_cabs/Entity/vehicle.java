package com.mega_city_cabs.mega_city_cabs.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "vehicle")
public class vehicle {
    @Id
    @Column(name = "vehicle_id", length = 5, nullable = false)
    private String vehicleId;

    @Column(name = "vehicle_number", length = 8, nullable = false)
    private String vehicleNumber;

    @Column(name = "vehicle_type", length = 10, nullable = false)
    private String vehicleType;

    @Column(name = "vehicle_model", length = 15, nullable = false)
    private String vehicleModel;

    @Column(name = "registered_date", nullable = false)
    private LocalDate registeredDate;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private administrator Admin;

    public vehicle() {
    }

    public vehicle(String vehicleId, String vehicleNumber, String vehicleType, String vehicleModel, LocalDate registeredDate, administrator admin) {
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

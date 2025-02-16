package com.mega_city_cabs.mega_city_cabs.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "driver")
public class driver {
    @Id
    @Column(name = "driver_id", length = 7, nullable = false)
    private String driverId;

    @Column(name = "first_name", length = 20, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 20, nullable = false)
    private String lastName;

    @Column(name = "contact", length = 10, nullable = false)
    private String contactNumber;

    @Column(name = "nic", length = 10, nullable = false)
    private String nic;

    @Column(name = "registered_date", nullable = false)
    private LocalDateTime registeredDate;

    @Column(name = "is_deleted", length = 1, nullable = false)
    private int isDeleted;

    @ManyToOne()
    @JoinColumn(name = "admin_id", nullable = false)
    private administrator admin;

    public driver() {
    }

    public driver(String driverId, String firstName, String lastName, String contactNumber, String nic, LocalDateTime registeredDate, int isDeleted, administrator admin) {
        this.driverId = driverId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.nic = nic;
        this.registeredDate = registeredDate;
        this.isDeleted = isDeleted;
        this.admin = admin;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public administrator getAdmin() {
        return admin;
    }

    public void setAdmin(administrator admin) {
        this.admin = admin;
    }

    public LocalDateTime getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDateTime registeredDate) {
        this.registeredDate = registeredDate;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}

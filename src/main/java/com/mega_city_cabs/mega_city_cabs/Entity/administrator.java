package com.mega_city_cabs.mega_city_cabs.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "Administrator")
public class administrator {
    @Id
    @Column(name = "admin_id", length = 7, nullable = false)
    private String adminId;

    @Column(name = "first_name", length = 10, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 20, nullable = false)
    private String lastName;

    @Column(name = "email", length = 50, nullable = false)
    private String enailAddress;

    @Column(name = "contact_number", length = 10, nullable = false)
    private  String contactNumber;

    @Column(name = "nic", length = 12, nullable = false)
    private String nic;

    @Column(name = "create_date", length = 20, nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "login_id", length = 10, nullable = false)
    private String loginId;

    @Column(name = "password", length = 10, nullable = false)
    private String password;

    public administrator() {
    }

    public administrator(String adminId, String firstName, String lastName, String enailAddress, String contactNumber, String nic, LocalDateTime createdDate, String loginId, String password) {
        this.adminId = adminId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enailAddress = enailAddress;
        this.contactNumber = contactNumber;
        this.nic = nic;
        this.createdDate = createdDate;
        this.loginId = loginId;
        this.password = password;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
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

    public String getEnailAddress() {
        return enailAddress;
    }

    public void setEnailAddress(String enailAddress) {
        this.enailAddress = enailAddress;
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

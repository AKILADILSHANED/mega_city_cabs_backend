package com.mega_city_cabs.mega_city_cabs.DTO;

import jakarta.persistence.Column;

public class customerRegisterDTO {

    private String firstName;
    private String lastName;
    private String contact;
    private String email;
    private String nic;
    private String address;
    private String password;

    public customerRegisterDTO() {
    }

    public customerRegisterDTO(String firstName, String lastName, String contact, String email, String nic, String address, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.email = email;
        this.nic = nic;
        this.address = address;
        this.password = password;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

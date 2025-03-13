package com.mega_city_cabs.mega_city_cabs.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class customer {
    @Id
    @Column(name = "customer_id", length = 7, nullable = false)
    private String customerId;
    @Column(name = "first_name", length = 20, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 20, nullable = false)
    private String lastName;
    @Column(name = "contact", length = 10, nullable = false)
    private String contact;
    @Column(name = "email", length = 50, nullable = false)
    private String email;
    @Column(name = "nic", length = 10, nullable = false)
    private String nic;
    @Column(name = "address", length = 100, nullable = false)
    private String address;
    @Column(name = "password", length = 15, nullable = false)
    private String password;

    public customer() {
    }

    public customer(String customerId, String firstName, String lastName, String contact, String email, String nic, String address, String password) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.email = email;
        this.nic = nic;
        this.address = address;
        this.password = password;
    }

    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

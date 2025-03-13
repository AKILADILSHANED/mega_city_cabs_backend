package com.mega_city_cabs.mega_city_cabs.Entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Registration_Requests")
public class CustomerRegistrationRequest {
    @Id
    @Column(name = "Request_Id", length = 10, nullable = false)
    private String requestId;
    @Column(name = "Request_Date", nullable = false)
    private LocalDateTime requestedDate;
    @Column(name = "Is_Confirmed", length = 1, nullable = false)
    private int isConfirmed;
    @Column(name = "Confirmed_Date", nullable = true)
    private LocalDateTime confirmDate;
    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private customer customer;

    public CustomerRegistrationRequest() {
    }
    public CustomerRegistrationRequest(String requestId, LocalDateTime requestedDate, int isConfirmed, LocalDateTime confirmDate, com.mega_city_cabs.mega_city_cabs.Entity.customer customer) {
        this.requestId = requestId;
        this.requestedDate = requestedDate;
        this.isConfirmed = isConfirmed;
        this.confirmDate = confirmDate;
        this.customer = customer;
    }
    public String getRequestId() {
        return requestId;
    }
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    public LocalDateTime getRequestedDate() {
        return requestedDate;
    }
    public void setRequestedDate(LocalDateTime requestedDate) {
        this.requestedDate = requestedDate;
    }
    public int getIsConfirmed() {
        return isConfirmed;
    }
    public void setIsConfirmed(int isConfirmed) {
        this.isConfirmed = isConfirmed;
    }
    public LocalDateTime getConfirmDate() {
        return confirmDate;
    }
    public void setConfirmDate(LocalDateTime confirmDate) {
        this.confirmDate = confirmDate;
    }
    public com.mega_city_cabs.mega_city_cabs.Entity.customer getCustomer() {
        return customer;
    }
    public void setCustomer(com.mega_city_cabs.mega_city_cabs.Entity.customer customer) {
        this.customer = customer;
    }
}

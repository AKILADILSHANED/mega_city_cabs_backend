package com.mega_city_cabs.mega_city_cabs.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "receipt")
public class receipt {

    @Id
    @Column(name = "Receipt_Number", length = 10, nullable = false)
    private String receiptNumber;

    @Column(name = "Receipt_Date", nullable = false)
    private LocalDateTime receiptDate;

    @Column(name = "Payment_Type", length = 20, nullable = false)
    private String paymentType;

    @Column(name = "Tax_Rate", nullable = false)
    private double taxRate;

    @Column(name = "Is_Deleted", length = 1, nullable = false)
    private int isDeleted;

    @Column(name = "Fare", length = 10, nullable = false)
    private double fare;

    @ManyToOne()
    @JoinColumn(name = "admin_id", nullable = false)
    private administrator admin;

    @ManyToOne()
    @JoinColumn(name = "customer_id", nullable = false)
    private customer customer;

    @ManyToOne()
    @JoinColumn(name = "booking_id", nullable = false)
    private booking booking;

    public receipt() {
    }

    public receipt(String receiptNumber, LocalDateTime receiptDate, String paymentType, double taxRate, int isDeleted, double fare, administrator admin, com.mega_city_cabs.mega_city_cabs.Entity.customer customer, com.mega_city_cabs.mega_city_cabs.Entity.booking booking) {
        this.receiptNumber = receiptNumber;
        this.receiptDate = receiptDate;
        this.paymentType = paymentType;
        this.taxRate = taxRate;
        this.isDeleted = isDeleted;
        this.fare = fare;
        this.admin = admin;
        this.customer = customer;
        this.booking = booking;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public LocalDateTime getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(LocalDateTime receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public administrator getAdmin() {
        return admin;
    }

    public void setAdmin(administrator admin) {
        this.admin = admin;
    }

    public com.mega_city_cabs.mega_city_cabs.Entity.customer getCustomer() {
        return customer;
    }

    public void setCustomer(com.mega_city_cabs.mega_city_cabs.Entity.customer customer) {
        this.customer = customer;
    }

    public com.mega_city_cabs.mega_city_cabs.Entity.booking getBooking() {
        return booking;
    }

    public void setBooking(com.mega_city_cabs.mega_city_cabs.Entity.booking booking) {
        this.booking = booking;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}

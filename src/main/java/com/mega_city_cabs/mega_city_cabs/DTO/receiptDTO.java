package com.mega_city_cabs.mega_city_cabs.DTO;

import com.mega_city_cabs.mega_city_cabs.Entity.administrator;
import com.mega_city_cabs.mega_city_cabs.Entity.booking;

import java.time.LocalDateTime;

public class receiptDTO {

    private String paymentType;
    private double taxRate;
    private double fare;
    private String customerId;
    private String bookingId;

    public receiptDTO() {
    }

    public receiptDTO(String paymentType, double taxRate, double fare, String customerId, String bookingId) {
        this.paymentType = paymentType;
        this.taxRate = taxRate;
        this.fare = fare;
        this.customerId = customerId;
        this.bookingId = bookingId;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
}

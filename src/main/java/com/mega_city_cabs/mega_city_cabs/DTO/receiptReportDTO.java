package com.mega_city_cabs.mega_city_cabs.DTO;

import java.time.LocalDateTime;

public class receiptReportDTO {

    private String receiptNumber;
    private LocalDateTime receiptDate;
    private String paymentType;
    private double fare;
    private double taxRate;
    private String admin;
    private String customer;

    public receiptReportDTO() {
    }

    public receiptReportDTO(String receiptNumber, LocalDateTime receiptDate, String paymentType, double fare, double taxRate, String admin, String customer) {
        this.receiptNumber = receiptNumber;
        this.receiptDate = receiptDate;
        this.paymentType = paymentType;
        this.fare = fare;
        this.taxRate = taxRate;
        this.admin = admin;
        this.customer = customer;
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

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public String getAdmin(String string) {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getCustomer(String string) {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}

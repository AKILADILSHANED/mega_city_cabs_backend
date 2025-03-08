package com.mega_city_cabs.mega_city_cabs.DTO;

import com.mega_city_cabs.mega_city_cabs.Entity.administrator;
import com.mega_city_cabs.mega_city_cabs.Entity.booking;
import com.mega_city_cabs.mega_city_cabs.Entity.customer;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class receiptPrintDTO {

    private String receiptNumber;
    private LocalDateTime receiptDate;
    private String paymentType;
    private double taxRate;
    private double fare;
    private String customerId;
    private String bookingId;
    private String AdminId;
    private double vatAmount;
    private double serviceCharge;
    private double totalDue;
    private String pickupLocation;
    private String destination;
    private int returnMessage;

    public receiptPrintDTO() {
    }

    public receiptPrintDTO(String receiptNumber, LocalDateTime receiptDate, String paymentType, double taxRate, double fare, String customerId, String bookingId, String adminId, double vatAmount, double serviceCharge, double totalDue, String pickupLocation, String destination, int returnMessage) {
        this.receiptNumber = receiptNumber;
        this.receiptDate = receiptDate;
        this.paymentType = paymentType;
        this.taxRate = taxRate;
        this.fare = fare;
        this.customerId = customerId;
        this.bookingId = bookingId;
        AdminId = adminId;
        this.vatAmount = vatAmount;
        this.serviceCharge = serviceCharge;
        this.totalDue = totalDue;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.returnMessage = returnMessage;
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

    public String getAdminId() {
        return AdminId;
    }

    public void setAdminId(String adminId) {
        AdminId = adminId;
    }

    public double getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(double vatAmount) {
        this.vatAmount = vatAmount;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public double getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(double totalDue) {
        this.totalDue = totalDue;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(int returnMessage) {
        this.returnMessage = returnMessage;
    }
}

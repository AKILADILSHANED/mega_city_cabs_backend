package com.mega_city_cabs.mega_city_cabs.Entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
public class booking {
    @Id
    @Column(name = "booking_id", length = 10, nullable = false)
    private String bookingId;
    @Column(name = "pickup_location", length = 50, nullable = false)
    private String pickupLocation;
    @Column(name = "destination", length = 50, nullable = false)
    private String destination;
    @Column(name = "booking_date", nullable = false)
    private LocalDateTime bookingDate;
    @Column(name = "vehicle_type", length = 30, nullable = false)
    private String vehicleType;
    @Column(name = "booking_type", length = 30, nullable = false)
    private String bookingType;
    @Column(name = "is_cancelled", length = 1, nullable = false)
    private int isCancelled;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private customer customerId;
    @ManyToOne
    @JoinColumn(name = "approved_by", nullable = true)
    private administrator confirmBy;

    public booking() {
    }

    public booking(String bookingId, String pickupLocation, String destination, LocalDateTime bookingDate, String vehicleType, String bookingType, int isCancelled, customer customerId, administrator confirmBy) {
        this.bookingId = bookingId;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.bookingDate = bookingDate;
        this.vehicleType = vehicleType;
        this.bookingType = bookingType;
        this.isCancelled = isCancelled;
        this.customerId = customerId;
        this.confirmBy = confirmBy;
    }
    public String getBookingId() {
        return bookingId;
    }
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
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
    public LocalDateTime getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }
    public String getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    public String getBookingType() {
        return bookingType;
    }
    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }
    public int getIsCancelled() {
        return isCancelled;
    }
    public void setIsCancelled(int isCancelled) {
        this.isCancelled = isCancelled;
    }
    public customer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(customer customerId) {
        this.customerId = customerId;
    }
    public administrator getConfirmBy() {
        return confirmBy;
    }
    public void setConfirmBy(administrator confirmBy) {
        this.confirmBy = confirmBy;
    }
}

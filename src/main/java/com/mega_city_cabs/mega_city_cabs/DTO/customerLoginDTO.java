package com.mega_city_cabs.mega_city_cabs.DTO;

public class customerLoginDTO {
    private String customerId;
    private int isConfirmed;

    public customerLoginDTO() {
    }

    public customerLoginDTO(String customerId, int isConfirmed) {
        this.customerId = customerId;
        this.isConfirmed = isConfirmed;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(int isConfirmed) {
        this.isConfirmed = isConfirmed;
    }
}

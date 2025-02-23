package com.mega_city_cabs.mega_city_cabs.DTO;

public class approveRequestDTO {
    private String customerId;
    private int approveCode;
    private String approveMessage;

    public approveRequestDTO() {
    }

    public approveRequestDTO(String customerId, int approveCode, String approveMessage) {
        this.customerId = customerId;
        this.approveCode = approveCode;
        this.approveMessage = approveMessage;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getApproveCode() {
        return approveCode;
    }

    public void setApproveCode(int approveCode) {
        this.approveCode = approveCode;
    }

    public String getApproveMessage() {
        return approveMessage;
    }

    public void setApproveMessage(String approveMessage) {
        this.approveMessage = approveMessage;
    }
}

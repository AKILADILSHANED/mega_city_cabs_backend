package com.mega_city_cabs.mega_city_cabs.DTO;


public class receiptConfirmDTO {
    private String receiptNumber;
    private String receiptMessageCode;

    public receiptConfirmDTO() {
    }

    public receiptConfirmDTO(String receiptNumber, String receiptMessageCode) {
        this.receiptNumber = receiptNumber;
        this.receiptMessageCode = receiptMessageCode;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getReceiptMessageCode() {
        return receiptMessageCode;
    }

    public void setReceiptMessageCode(String receiptMessageCode) {
        this.receiptMessageCode = receiptMessageCode;
    }
}

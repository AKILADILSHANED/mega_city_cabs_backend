package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.DTO.bookingDetailsForReceipt;
import com.mega_city_cabs.mega_city_cabs.DTO.receiptConfirmDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.receiptDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.receiptPrintDTO;

public interface receiptService {
    public receiptConfirmDTO issueReceipt(receiptDTO receiptDto);
    public bookingDetailsForReceipt getBookingDetailsForReceipt(String bookingId);
    public receiptPrintDTO getReceiptDetails(String receiptNumber);
    public receiptPrintDTO receiptReprint(String receiptNumber);
    public String deleteReceipt(String receiptNumber);

}

package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.DTO.bookingDetailsForReceipt;
import com.mega_city_cabs.mega_city_cabs.DTO.receiptDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

public interface receiptService {
    public String issueReceipt(receiptDTO receiptDto);
    public bookingDetailsForReceipt getBookingDetailsForReceipt(String bookingId);
}

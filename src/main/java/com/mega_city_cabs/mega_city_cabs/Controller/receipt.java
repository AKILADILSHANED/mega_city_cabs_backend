package com.mega_city_cabs.mega_city_cabs.Controller;

import com.mega_city_cabs.mega_city_cabs.DTO.bookingDetailsForReceipt;
import com.mega_city_cabs.mega_city_cabs.DTO.receiptDTO;
import com.mega_city_cabs.mega_city_cabs.Service.receiptIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3001", allowCredentials = "true")
@RequestMapping("/api/v1/receipts")
public class receipt {

    @Autowired
    receiptIMPL receipt;

    @PostMapping("/new-receipt")
    private String issueReceipt(@RequestBody receiptDTO receiptDto){
        return receipt.issueReceipt(receiptDto);
    }

    @GetMapping("/booking-details")
    private bookingDetailsForReceipt getBookingDetailsForReceipt(@RequestParam String bookingId){
        return receipt.getBookingDetailsForReceipt(bookingId);
    }
}

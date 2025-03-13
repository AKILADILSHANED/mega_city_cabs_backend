package com.mega_city_cabs.mega_city_cabs.Controller;

import com.mega_city_cabs.mega_city_cabs.DTO.bookingDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.customerDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.receiptReportDTO;
import com.mega_city_cabs.mega_city_cabs.Service.reportIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/reports")
public class reports {

    @Autowired
    reportIMPL reports;

    @GetMapping("/customer-report")
    private List<customerDTO> getCustomerReport(){
        return reports.getCustomerReport();
    }

    @GetMapping("/booking-report")
    private List<bookingDTO> getBookingReport(){
        return reports.getBookingReport();
    }

    @GetMapping("/receipt-report")
    private List<receiptReportDTO> getReceiptReport(){
        return reports.getReceiptReport();
    }
}

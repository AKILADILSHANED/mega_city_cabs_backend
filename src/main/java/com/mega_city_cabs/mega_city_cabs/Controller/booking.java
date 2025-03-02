package com.mega_city_cabs.mega_city_cabs.Controller;

import com.mega_city_cabs.mega_city_cabs.DTO.approveBookingDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.bookingHistoryDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.cancelBookingDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.newBookingDTO;
import com.mega_city_cabs.mega_city_cabs.Service.bookingIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(
        origins = "http://localhost:3000",
        allowedHeaders = "*",
        allowCredentials = "true" 
)
@RequestMapping("/api/v1/booking")
public class booking {

    @Autowired
    bookingIMPL booking;

    @PostMapping("/newBooking")
    private String newBooking(@RequestBody newBookingDTO newBooking){
        return booking.newBooking(newBooking);
    }

    @GetMapping("/displayBookingForCancel")
    private cancelBookingDTO displayBookingForCancel(@RequestParam String bookingId){
        return booking.displayBookingForCancel(bookingId);
    }

    @GetMapping("/cancelBooking")
    private String cancelBooking(@RequestParam String bookingId){
        return booking.cancelBooking(bookingId);
    }

    @GetMapping("/booking-history")
    private List<bookingHistoryDTO> bookingHistory(){
        return booking.bookingHistory();
    }

    @GetMapping("/booking-approval")
    @CrossOrigin(origins = "http://localhost:3001")
    private List<approveBookingDTO> approveBookings(){
        return booking.approveBookings();
    }

    @GetMapping("/check-approval")
    @CrossOrigin(origins = "http://localhost:3001")
    private String checkApproval(@RequestParam String bookingId){
        return booking.checkApproval(bookingId);
    }

    @GetMapping("/rejectBooking")
    @CrossOrigin(origins = "http://localhost:3001")
    private String rejectBooking(@RequestParam String bookingId){
        return booking.rejectBooking(bookingId);
    }
}

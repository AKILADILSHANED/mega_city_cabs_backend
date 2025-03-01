package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.DTO.bookingHistoryDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.cancelBookingDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.newBookingDTO;

import java.util.List;


public interface customerBooking {
    public String newBooking(newBookingDTO newBooking);
    public cancelBookingDTO displayBookingForCancel(String bookingId);
    public String cancelBooking(String bookingId);
    public List<bookingHistoryDTO> bookingHistory();
}

package com.mega_city_cabs.mega_city_cabs.Test;

import com.mega_city_cabs.mega_city_cabs.DTO.bookingHistoryDTO;
import com.mega_city_cabs.mega_city_cabs.Service.bookingIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class displayPendingBookingTesting {
    @Autowired
    bookingIMPL pendingBookingTest;

    public void bookingHistory(){
        List<bookingHistoryDTO> bookingHistory = pendingBookingTest.bookingHistory();
        for(bookingHistoryDTO bookingObj: bookingHistory){
            System.out.println(
                    "Booking ID " + bookingObj.getBookingId() + " | " +
                    "Booking Date " + bookingObj.getBookingDate() + " | " +
                    "Booking Type " + bookingObj.getBookingType() + " | " +
                    "Pickup " + bookingObj.getPickupLocation() + " | " +
                    "Destination " + bookingObj.getDestination() + " | " +
                    "Vehicle Number " + bookingObj.getVehicleNumber() + " | " +
                    "First Name " + bookingObj.getFirstName() + " | "
            );
        }
    }
}

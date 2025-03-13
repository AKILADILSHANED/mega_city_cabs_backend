package com.mega_city_cabs.mega_city_cabs.Test;

import com.mega_city_cabs.mega_city_cabs.DTO.bookingHistoryDTO;
import com.mega_city_cabs.mega_city_cabs.Service.bookingIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class bookingHistoryTesting{
    @Autowired
    bookingIMPL testBookingHistory;
    public void bookingHistoryTest(){
        List<bookingHistoryDTO> list = testBookingHistory.bookingHistory();

        for(bookingHistoryDTO bookingObj: list){
            System.out.println("Booking ID: " + bookingObj.getBookingId() + "|" +
                    " Booking Date: " + bookingObj.getBookingDate() + "|" +
                    " Booking Type: " + bookingObj.getBookingType() + "|" +
                    " Pickup : " + bookingObj.getPickupLocation() + "|" +
                    " Destination: " + bookingObj.getDestination() + "|" +
                    " Booking Type: " + bookingObj.getVehicleNumber() + "|" +
                    " Customer: " + bookingObj.getFirstName()
            );
        }
    }
}

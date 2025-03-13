package com.mega_city_cabs.mega_city_cabs.Test;

import com.mega_city_cabs.mega_city_cabs.DTO.bookingDTO;
import com.mega_city_cabs.mega_city_cabs.Service.reportIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class bookingDetailsReportTesting {
    @Autowired
    reportIMPL bookingReportTesting;
    public void testingBookingDetails(){
        List<bookingDTO> bookingList = bookingReportTesting.getBookingReport();
        for(bookingDTO bookingListObj: bookingList){
            System.out.println(
                    "BookingId: " + bookingListObj.getBookingId() +
                            " Pickup " + bookingListObj.getPickupLocation() +
                            " Destination " + bookingListObj.getDestination() +
                            " Booking Date " + bookingListObj.getBookingDate() +
                            " Vehicle Type " + bookingListObj.getVehicleType() +
                            " Booking Type " + bookingListObj.getBookingType() +
                            " Customer " + bookingListObj.getCustomerId() +
                            " Confirmed By " + bookingListObj.getConfirmBy()

            );
        }
    }
}

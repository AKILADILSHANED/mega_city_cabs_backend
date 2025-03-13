package com.mega_city_cabs.mega_city_cabs.Test;

import com.mega_city_cabs.mega_city_cabs.Service.bookingIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class cancelBookingTesting {
    @Autowired
    bookingIMPL testCancelBooking;
    public String cancelBookingTesting(){
        return testCancelBooking.cancelBooking("BK00003");
    }
}

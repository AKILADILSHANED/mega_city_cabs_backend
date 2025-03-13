package com.mega_city_cabs.mega_city_cabs.Test;

import com.mega_city_cabs.mega_city_cabs.Service.bookingIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class bookingApprovalTesting {
    @Autowired
    bookingIMPL bookingTesting;
    public String bookingApproval(){
        return bookingTesting.checkApproval("BK00004");
    }
}

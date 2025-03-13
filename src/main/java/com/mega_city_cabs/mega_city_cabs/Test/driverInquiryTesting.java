package com.mega_city_cabs.mega_city_cabs.Test;


import com.mega_city_cabs.mega_city_cabs.DTO.driverSearchDTO;
import com.mega_city_cabs.mega_city_cabs.Service.driverServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class driverInquiryTesting {
    @Autowired
    driverServiceIMPL driverInquiryTest;
    public String driverInquiry(){
        return driverInquiryTest.driverSearch("DVR003").getFirstName() + " " + driverInquiryTest.driverSearch("DVR003").getLastName();
    }
}

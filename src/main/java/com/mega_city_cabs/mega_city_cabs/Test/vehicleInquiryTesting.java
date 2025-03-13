package com.mega_city_cabs.mega_city_cabs.Test;

import com.mega_city_cabs.mega_city_cabs.DTO.vehicleSearchDTO;
import com.mega_city_cabs.mega_city_cabs.Service.vehicleServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class vehicleInquiryTesting {
    @Autowired
    vehicleServiceIMPL vehicleInquiryTest;
    public String inquiryVehicle(){
        return vehicleInquiryTest.vehicleSearch("VH004").getVehicleNumber();
    }
}

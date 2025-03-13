package com.mega_city_cabs.mega_city_cabs.Test;

import com.mega_city_cabs.mega_city_cabs.Service.customerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class customerLoginTesting {
    @Autowired
    customerServiceIMPL customerService;
    public String customerLoginTesting(){
        return customerService.customerLogin("akila@gmail.com", "akila@123");
    }
}

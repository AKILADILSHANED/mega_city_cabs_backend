package com.mega_city_cabs.mega_city_cabs.Test;

import com.mega_city_cabs.mega_city_cabs.Service.driverServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class driverDeleteTesting {
    @Autowired
    driverServiceIMPL driverDelete;
    public String driverRemovalTest(){
        return driverDelete.removeDriver("DVR003");
    }
}

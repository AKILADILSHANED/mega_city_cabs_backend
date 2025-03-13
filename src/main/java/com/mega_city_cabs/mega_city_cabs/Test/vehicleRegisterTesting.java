package com.mega_city_cabs.mega_city_cabs.Test;

import com.mega_city_cabs.mega_city_cabs.DTO.driverRegisterDTO;
import com.mega_city_cabs.mega_city_cabs.Service.driverServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class vehicleRegisterTesting {
    @Autowired
    driverServiceIMPL driverRegister;

    public String driverRegisterTesting(){
        driverRegisterDTO driverRegisterDto = new driverRegisterDTO(
                "Nimal",
                "Jayaweera",
                "0711064457",
                "945556331V"
        );
        return driverRegister.registerDriver(driverRegisterDto);
    }
}

package com.mega_city_cabs.mega_city_cabs.Test;

import com.mega_city_cabs.mega_city_cabs.DTO.registerVehicleDTO;
import com.mega_city_cabs.mega_city_cabs.Service.vehicleServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class vehicleAddTesting {
    @Autowired
    vehicleServiceIMPL vehicleTest;

    public String registerVehicleTest(){
        registerVehicleDTO vehicle = new registerVehicleDTO(
                "CAR-3235",
                "Car",
                "Niisan FB15"
        );
        return vehicleTest.registerVehicle(vehicle);
    }
}

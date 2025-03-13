package com.mega_city_cabs.mega_city_cabs.Test;

import com.mega_city_cabs.mega_city_cabs.DTO.vehicleUpdateDTO;
import com.mega_city_cabs.mega_city_cabs.Service.vehicleServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class vehicleUpdateTesting {
    @Autowired
    vehicleServiceIMPL vehicleUpdateTesting;
    @Autowired
    vehicleUpdateDTO vehicleUpdate;
    public String vehicleUpdateTesting(){
        vehicleUpdate = new vehicleUpdateDTO(
                "VH004",
                "CAB-6523",
                "VAN",
                "KDH"
        );
        return vehicleUpdateTesting.updateVehicle(vehicleUpdate);
    }
}

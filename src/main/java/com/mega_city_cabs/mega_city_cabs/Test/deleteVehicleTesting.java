package com.mega_city_cabs.mega_city_cabs.Test;

import com.mega_city_cabs.mega_city_cabs.Service.vehicleServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class deleteVehicleTesting {
    @Autowired
    vehicleServiceIMPL vehicleDelete;
    public String vehicleDeleteTesting(){
        return vehicleDelete.deleteVehicle("VH004");
    }
}

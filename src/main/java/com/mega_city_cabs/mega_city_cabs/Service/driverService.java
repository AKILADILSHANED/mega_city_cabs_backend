package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.DTO.driverRegisterDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.driverSearchDTO;

public interface driverService {
    public String registerDriver(driverRegisterDTO driverRegister);
    public driverSearchDTO driverSearch(String driverId);
}

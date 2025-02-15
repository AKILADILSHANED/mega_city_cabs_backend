package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.DTO.registerVehicleDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.vehicleSearchDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.vehicleUpdateDTO;

public interface vehicleService {
    public String registerVehicle(registerVehicleDTO registerVehicleDTO);
    public vehicleSearchDTO vehicleSearch(String vehicleId);
    public String updateVehicle(vehicleUpdateDTO vehicleUpdate);
    public String deleteVehicle(String vehicleId);
}

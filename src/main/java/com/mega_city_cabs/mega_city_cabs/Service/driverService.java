package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.DTO.driverDataForAssignDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.driverRegisterDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.driverSearchDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.driverUpdateDTO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface driverService {
    public String registerDriver(driverRegisterDTO driverRegister);
    public driverSearchDTO driverSearch(String driverId);
    public String driverUpdate(driverUpdateDTO driverUpdate);
    public String removeDriver(String driverId);
    public List<driverDataForAssignDTO> getDriverDataForAssign();
    public String assignDriver(String driverId, String bookingId);
}

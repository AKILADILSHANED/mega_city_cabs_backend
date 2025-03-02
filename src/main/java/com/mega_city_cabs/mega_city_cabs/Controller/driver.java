package com.mega_city_cabs.mega_city_cabs.Controller;

import com.mega_city_cabs.mega_city_cabs.DTO.driverDataForAssignDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.driverRegisterDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.driverSearchDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.driverUpdateDTO;
import com.mega_city_cabs.mega_city_cabs.Service.driverServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/api/v1/driver")
public class driver {

    @Autowired
    driverServiceIMPL driverService;

    @PostMapping("/driver-register")
    private String registerDriver(@RequestBody driverRegisterDTO driverRegister){
        return driverService.registerDriver(driverRegister);
    }

    @GetMapping("/driver-search")
    private driverSearchDTO driverSearch(@RequestParam String driverId){
        return driverService.driverSearch(driverId);
    }

    @PostMapping("/driver-update")
    private String driverUpdate(@RequestBody driverUpdateDTO driverUpdate){
        return driverService.driverUpdate(driverUpdate);
    }

    @PostMapping("/driver-remove")
    private String removeDriver(@RequestParam String driverId){
        return driverService.removeDriver(driverId);
    }

    @GetMapping("/get-driver-data")
    @CrossOrigin(origins = "http://localhost:3001")
    private List<driverDataForAssignDTO> getDriverDataForAssign(){
        return driverService.getDriverDataForAssign();
    }

    @PostMapping("/assign-driver")
    @CrossOrigin(origins = "http://localhost:3001")
    private String assignDriver(@RequestParam String driverId, String bookingId){
        return driverService.assignDriver(driverId, bookingId);
    }
}

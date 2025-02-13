package com.mega_city_cabs.mega_city_cabs.Controller;

import com.mega_city_cabs.mega_city_cabs.DTO.registerVehicleDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.vehicleSearchDTO;
import com.mega_city_cabs.mega_city_cabs.Service.vehicleServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/vehicle")
public class vehicle {

    @Autowired
    vehicleServiceIMPL vehicleService;

    @PostMapping("/vehicle-register")
    private String registerVehicle(@RequestBody registerVehicleDTO registerVehicleDTO){

        return vehicleService.registerVehicle(registerVehicleDTO);
    }

    @GetMapping("/vehicle-search")
    private vehicleSearchDTO vehicleSearch(@RequestParam String vehicleId){
        return vehicleService.vehicleSearch(vehicleId);
    }
}

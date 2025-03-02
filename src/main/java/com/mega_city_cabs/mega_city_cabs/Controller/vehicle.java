package com.mega_city_cabs.mega_city_cabs.Controller;

import com.mega_city_cabs.mega_city_cabs.DTO.registerVehicleDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.vehicleDataForAssignDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.vehicleSearchDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.vehicleUpdateDTO;
import com.mega_city_cabs.mega_city_cabs.Service.vehicleServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3001", allowCredentials = "true")
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

    @PostMapping("/vehicle-update")
    private String updateVehicle(@RequestBody vehicleUpdateDTO vehicleUpdate){
        return vehicleService.updateVehicle(vehicleUpdate);
    }

    @PostMapping("/vehicle-delete")
    private String deleteVehicle(@RequestParam String vehicleId){
        return vehicleService.deleteVehicle(vehicleId);
    }

    @GetMapping("/vehicle-data-assign")
    private List<vehicleDataForAssignDTO> assignVehicleData(){
        return vehicleService.assignVehicleData();
    }

    @PostMapping("/assign-vehicle")
    @CrossOrigin(origins = "http://localhost:3001")
    private String assignVehicle(@RequestParam String vehicleId, String bookingId){
        return vehicleService.assignVehicle(vehicleId, bookingId);
    }
}

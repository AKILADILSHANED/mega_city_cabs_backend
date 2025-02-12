package com.mega_city_cabs.mega_city_cabs.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/vehicle")
public class vehicle {
    @PostMapping("/vehicle-register")
    private String registerVehicle(){

        return "";
    }
}

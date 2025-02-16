package com.mega_city_cabs.mega_city_cabs.Controller;

import com.mega_city_cabs.mega_city_cabs.DTO.driverRegisterDTO;
import com.mega_city_cabs.mega_city_cabs.Service.driverServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/driver")
public class driver {

    @Autowired
    driverServiceIMPL driverService;

    @PostMapping("/driver-register")
    private String registerDriver(@RequestBody driverRegisterDTO driverRegister){
        return driverService.registerDriver(driverRegister);
    }
}

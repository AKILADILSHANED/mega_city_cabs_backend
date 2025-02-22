package com.mega_city_cabs.mega_city_cabs.Controller;

import com.mega_city_cabs.mega_city_cabs.DTO.customerRegisterDTO;
import com.mega_city_cabs.mega_city_cabs.Service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customer")
public class customer {

    @Autowired
    customerService customerServices;

    @GetMapping("/customer-login")
    private String customerLogin(@RequestParam String email, String password){
        return customerServices.customerLogin(email, password);
    }

    @PostMapping("/customer-register")
    private String customerRegister(@RequestBody customerRegisterDTO registerCustomer){
        return customerServices.customerRegister(registerCustomer);
    }
}

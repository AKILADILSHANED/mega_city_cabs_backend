package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.DTO.customerRegisterDTO;
import org.springframework.stereotype.Service;

public interface customerService {
    public String customerLogin(String email, String password);
    public String customerRegister(customerRegisterDTO registerCustomer);
}

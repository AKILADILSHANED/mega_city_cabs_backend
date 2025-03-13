package com.mega_city_cabs.mega_city_cabs.Test;
import com.mega_city_cabs.mega_city_cabs.DTO.customerRegisterDTO;
import com.mega_city_cabs.mega_city_cabs.Service.customerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class customerRegistrationTesting {
    @Autowired
    customerServiceIMPL customerService;
    customerRegisterDTO dtoObject = new customerRegisterDTO(
            "Akila",
            "Edirisooriya",
            "0762562712",
            "akila@gmail.com",
            "943383189V",
            "Hokandara",
            "akila@123"
    );
    public String customerTesting(){
        return customerService.customerRegister(dtoObject);
    }

}

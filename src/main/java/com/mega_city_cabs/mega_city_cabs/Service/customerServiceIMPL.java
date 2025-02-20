package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.Repository.customerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class customerServiceIMPL implements customerService{

    @Autowired
    customerRepo customerRepository;

    @Override
    public String customerLogin(String email, String password) {
        try{
            String customerAvailability = customerRepository.searchLoginCustomer(email, password);
            if(customerAvailability == null){
                return "0";
            }else {
                return "1";
            }
        }catch (Exception e){
            return e.getMessage();
        }
    }
}

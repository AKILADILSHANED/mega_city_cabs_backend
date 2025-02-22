package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.DTO.customerRegisterDTO;
import com.mega_city_cabs.mega_city_cabs.Entity.customer;
import com.mega_city_cabs.mega_city_cabs.Repository.customerRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    @Transactional
    @Override
    public String customerRegister(customerRegisterDTO registerCustomer) {
        String lastCustomerId;
        String newCustomerId;

        //Generate a new Customer ID.
        try{
            lastCustomerId = customerRepository.getLastCustomerId();
            if(lastCustomerId == null){
                newCustomerId = "CUS0001";
            }else{
                int numericId = Integer.parseInt(lastCustomerId.replace("CUS", ""))+ 1;
                newCustomerId = String.format("CUS%04d", numericId);
            }
        }catch (Exception e){
            return e.getMessage();
        }

        //Register new Customer to the Database.
        try{
            customer registeredCustomer = new customer(
                    newCustomerId,
                    registerCustomer.getFirstName(),
                    registerCustomer.getLastName(),
                    registerCustomer.getContact(),
                    registerCustomer.getEmail(),
                    registerCustomer.getNic(),
                    registerCustomer.getAddress(),
                    registerCustomer.getPassword(),
                    LocalDateTime.now()
            );
            customerRepository.save(registeredCustomer);
            return "You are successfully registered to our services. You will receive a confirmation message to your registered Email address!";
        }catch (Exception e){
            return "An error occurred while registering process. Please try again later!";
        }
    }
}

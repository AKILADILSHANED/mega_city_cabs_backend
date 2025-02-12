package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.DTO.registerVehicleDTO;
import com.mega_city_cabs.mega_city_cabs.Repository.adminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminServiceIMPL implements adminService {

    @Autowired
    adminRepo login;

    @Override
    public boolean adminLogin(String userName, String password) {
        String loginId = userName;
        String pssword = password;
        return login.adminExistance(userName, password);
    }

}

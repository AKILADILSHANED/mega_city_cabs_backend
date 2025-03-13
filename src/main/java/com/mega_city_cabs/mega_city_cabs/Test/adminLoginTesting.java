package com.mega_city_cabs.mega_city_cabs.Test;

import com.mega_city_cabs.mega_city_cabs.Service.adminServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class adminLoginTesting{
    @Autowired
    adminServiceIMPL adminTesting;
    public boolean testAdminLogin(){
        return adminTesting.adminLogin("ADMIN", "admin@123");
    }
}

package com.mega_city_cabs.mega_city_cabs.Controller;

import com.mega_city_cabs.mega_city_cabs.Service.adminServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin(
        allowCredentials = "true",
        origins = "http://localhost:3001"
)
public class admin {

    @Autowired
    adminServiceIMPL adminLogin;

    @PostMapping("/admin-login")
    private boolean adminLogin(@RequestParam String userName, @RequestParam String password){
            String loginId = userName;
            String pssword = password;

        return adminLogin.adminLogin(userName, password);
    }
}

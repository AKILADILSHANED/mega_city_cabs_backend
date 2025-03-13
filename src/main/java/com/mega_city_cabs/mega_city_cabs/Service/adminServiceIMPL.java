package com.mega_city_cabs.mega_city_cabs.Service;
import com.mega_city_cabs.mega_city_cabs.Repository.adminRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminServiceIMPL implements adminService {

    @Autowired
    adminRepo login;

    @Autowired
    HttpSession session;

    @Override
    public boolean adminLogin(String userName, String password) {
        boolean adminAvailability = login.adminExistance(userName, password);
        if(adminAvailability){
            String adminId = login.getAdminId(userName, password);
            session.setAttribute("admin_id", adminId);
            return true;
        }else{
            return false;
        }
    }
}

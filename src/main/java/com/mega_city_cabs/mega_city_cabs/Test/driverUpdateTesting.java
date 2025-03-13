package com.mega_city_cabs.mega_city_cabs.Test;

import com.mega_city_cabs.mega_city_cabs.DTO.driverUpdateDTO;
import com.mega_city_cabs.mega_city_cabs.Service.driverServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class driverUpdateTesting {
    @Autowired
    driverServiceIMPL driverUpdate;
    public String driverUpdateTesting(){
        driverUpdateDTO updateDTO = new driverUpdateDTO(
                "DVR003",
                "Chamara",
                "Samaraweera",
                "0112357905",
                "895523694V",
                LocalDateTime.now()
        );
        return driverUpdate.driverUpdate(updateDTO);
    }
}

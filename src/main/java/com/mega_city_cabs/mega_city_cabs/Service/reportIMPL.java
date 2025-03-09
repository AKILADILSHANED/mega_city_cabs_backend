package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.DTO.bookingDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.customerDTO;
import com.mega_city_cabs.mega_city_cabs.Entity.customer;
import com.mega_city_cabs.mega_city_cabs.SqlMappers.bookingDetailsMapper;
import com.mega_city_cabs.mega_city_cabs.SqlMappers.customerDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reportIMPL implements reports{

    @Autowired
    JdbcTemplate template;

    @Override
    public List<customerDTO> getCustomerReport() {
        String Sql = "SELECT * FROM customer";
        return template.query(Sql, new customerDetailsMapper());
    }

    @Override
    public List<bookingDTO> getBookingReport() {
        String Sql = "SELECT * FROM booking";
        return template.query(Sql, new bookingDetailsMapper());
    }
}

package com.mega_city_cabs.mega_city_cabs.Repository;

import com.mega_city_cabs.mega_city_cabs.DTO.pendingCustomerRegistrationsDTO;
import com.mega_city_cabs.mega_city_cabs.SqlMappers.PendingCustomerRegistrationsRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class pendingRegistration {

    @Autowired
    JdbcTemplate template;

    public List<pendingCustomerRegistrationsDTO> pendingRegistrations(){

        String sql = "SELECT cus.customer_id AS 'customerId', cus.first_name AS 'firstName', cus.last_name AS 'lastName', cus.contact AS 'contact', req.request_date AS 'requestedDate' FROM customer cus LEFT JOIN registration_requests req ON  cus.customer_id = req.customer_id WHERE req.is_confirmed = 0";
        return template.query(sql, new PendingCustomerRegistrationsRowMapper());
    }
}

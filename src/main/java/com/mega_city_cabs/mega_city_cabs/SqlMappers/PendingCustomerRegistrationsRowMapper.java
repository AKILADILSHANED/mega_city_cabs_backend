package com.mega_city_cabs.mega_city_cabs.SqlMappers;

import com.mega_city_cabs.mega_city_cabs.DTO.pendingCustomerRegistrationsDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class PendingCustomerRegistrationsRowMapper implements RowMapper<pendingCustomerRegistrationsDTO> {

    @Override
    public pendingCustomerRegistrationsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        pendingCustomerRegistrationsDTO registrationDTO = new pendingCustomerRegistrationsDTO();
                registrationDTO.setCustomerId(rs.getString("customerId"));
                registrationDTO.setFirstName(rs.getString("firstName"));
                registrationDTO.setLastName(rs.getString("lastName"));
                registrationDTO.setContact(rs.getString("contact"));
                registrationDTO.setRequestedDate(rs.getObject("requestedDate", LocalDateTime.class));

        return registrationDTO;
    }
}

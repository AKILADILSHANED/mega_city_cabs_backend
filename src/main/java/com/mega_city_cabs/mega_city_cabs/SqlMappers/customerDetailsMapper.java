package com.mega_city_cabs.mega_city_cabs.SqlMappers;

import com.mega_city_cabs.mega_city_cabs.DTO.customerDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class customerDetailsMapper implements RowMapper<customerDTO> {
    @Override
    public customerDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        customerDTO customer = new customerDTO();
        customer.setCustomerId(rs.getString(1));
        customer.setAddress(rs.getString(2));
        customer.setContact(rs.getString(3));
        customer.setEmail(rs.getString(4));
        customer.setFirstName(rs.getString(5));
        customer.setLastName(rs.getString(6));
        customer.setNic(rs.getString(7));

        return customer;
    }
}

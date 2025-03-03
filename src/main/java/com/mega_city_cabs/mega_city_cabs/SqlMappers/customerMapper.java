package com.mega_city_cabs.mega_city_cabs.SqlMappers;

import com.mega_city_cabs.mega_city_cabs.Entity.customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class customerMapper implements RowMapper<customer> {
    @Override
    public customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        customer customerObject = new customer();
        customerObject.setCustomerId(rs.getString(1));
        customerObject.setAddress(rs.getString(2));
        customerObject.setContact(rs.getString(3));
        customerObject.setEmail(rs.getString(4));
        customerObject.setFirstName(rs.getString(5));
        customerObject.setLastName(rs.getString(6));
        customerObject.setNic(rs.getString(7));
        customerObject.setPassword(rs.getString(8));
        return customerObject;
    }
}

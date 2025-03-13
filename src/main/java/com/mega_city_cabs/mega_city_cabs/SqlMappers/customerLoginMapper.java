package com.mega_city_cabs.mega_city_cabs.SqlMappers;

import com.mega_city_cabs.mega_city_cabs.DTO.customerLoginDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class customerLoginMapper implements RowMapper<customerLoginDTO> {
    @Override
    public customerLoginDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        customerLoginDTO customerLogin = new customerLoginDTO(
                rs.getString(1),
                rs.getInt(2)
        );
        return customerLogin;
    }
}

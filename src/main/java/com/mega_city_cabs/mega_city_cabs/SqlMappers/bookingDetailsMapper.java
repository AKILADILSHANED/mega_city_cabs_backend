package com.mega_city_cabs.mega_city_cabs.SqlMappers;

import com.mega_city_cabs.mega_city_cabs.DTO.bookingDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class bookingDetailsMapper implements RowMapper<bookingDTO> {
    @Override
    public bookingDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        bookingDTO bookingObject = new bookingDTO();

        bookingObject.setBookingId(rs.getString(1));
        bookingObject.setBookingDate(rs.getObject(2, LocalDateTime.class));
        bookingObject.setBookingType(rs.getString(3));
        bookingObject.setDestination(rs.getString(4));
        bookingObject.setPickupLocation(rs.getString(6));
        bookingObject.setVehicleType(rs.getString(7));
        return bookingObject;
    }
}

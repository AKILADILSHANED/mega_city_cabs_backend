package com.mega_city_cabs.mega_city_cabs.SqlMappers;

import com.mega_city_cabs.mega_city_cabs.DTO.bookingHistoryDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class bookingHistoryMapper implements RowMapper<bookingHistoryDTO> {
    @Override
    public bookingHistoryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        bookingHistoryDTO bookingHistory = new bookingHistoryDTO();
                bookingHistory.setBookingId(rs.getString("Booking ID"));
                bookingHistory.setBookingDate(rs.getObject("Date", LocalDateTime.class));
                bookingHistory.setBookingType(rs.getString("Type"));
                bookingHistory.setPickupLocation(rs.getString("Pick Up"));
                bookingHistory.setDestination(rs.getString("Destination"));
                bookingHistory.setVehicleNumber(rs.getString("Vehicle"));
                bookingHistory.setFirstName(rs.getString("Driver"));

                return bookingHistory;
    }
}

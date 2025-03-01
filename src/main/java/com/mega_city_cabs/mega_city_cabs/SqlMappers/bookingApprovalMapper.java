package com.mega_city_cabs.mega_city_cabs.SqlMappers;

import com.mega_city_cabs.mega_city_cabs.DTO.approveBookingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class bookingApprovalMapper implements RowMapper<approveBookingDTO> {

    @Override
    public approveBookingDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        approveBookingDTO bookingApproval = new approveBookingDTO();

        bookingApproval.setBookingId(rs.getString("Booking ID"));
        bookingApproval.setBookingDate(rs.getObject("Date", LocalDateTime.class));
        bookingApproval.setBookingType(rs.getString("Type"));
        bookingApproval.setPickupLocation(rs.getString("Pick Up"));
        bookingApproval.setDestination(rs.getString("Destination"));
        bookingApproval.setVehicleNumber(rs.getString("Vehicle"));
        bookingApproval.setFirstName(rs.getString("Driver"));
        bookingApproval.setFirst_name(rs.getString("Customer First Name"));
        bookingApproval.setLast_name(rs.getString("Customer Last Name"));
        bookingApproval.setContact(rs.getString("Contact"));

        return bookingApproval;
    }
}

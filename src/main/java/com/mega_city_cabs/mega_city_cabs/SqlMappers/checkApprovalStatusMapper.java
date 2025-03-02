package com.mega_city_cabs.mega_city_cabs.SqlMappers;

import com.mega_city_cabs.mega_city_cabs.DTO.checkBookingApprovalDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class checkApprovalStatusMapper implements RowMapper<checkBookingApprovalDTO> {
    @Override
    public checkBookingApprovalDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        checkBookingApprovalDTO checkBooking = new checkBookingApprovalDTO();
        checkBooking.setBookingId(rs.getString(1));
        checkBooking.setAssignmentId(rs.getString(2));
        checkBooking.setAssignmentIdVehicle(rs.getString(3));
        return checkBooking;
    }
}

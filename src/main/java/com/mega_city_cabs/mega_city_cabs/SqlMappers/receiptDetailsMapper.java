package com.mega_city_cabs.mega_city_cabs.SqlMappers;

import com.mega_city_cabs.mega_city_cabs.DTO.receiptPrintDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class receiptDetailsMapper implements RowMapper<receiptPrintDTO> {

    @Override
    public receiptPrintDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        receiptPrintDTO receiptDetails = new receiptPrintDTO();
        receiptDetails.setReceiptNumber(rs.getString(1));
        receiptDetails.setReceiptDate(rs.getObject(2, LocalDateTime.class));
        receiptDetails.setPaymentType(rs.getString(3));
        receiptDetails.setTaxRate(rs.getDouble(4));
        receiptDetails.setFare(rs.getDouble(5));
        receiptDetails.setCustomerId(rs.getString(6));
        receiptDetails.setBookingId(rs.getString(7));
        receiptDetails.setAdminId(rs.getString(8));
        receiptDetails.setPickupLocation(rs.getString(9));
        receiptDetails.setDestination(rs.getString(10));
        receiptDetails.setReturnMessage("");
        return receiptDetails;
    }
}

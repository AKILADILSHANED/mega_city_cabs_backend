package com.mega_city_cabs.mega_city_cabs.SqlMappers;

import com.mega_city_cabs.mega_city_cabs.DTO.bookingDetailsForReceipt;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class getBookingDetailsForReceiptMapper implements RowMapper<bookingDetailsForReceipt> {

    @Override
    public bookingDetailsForReceipt mapRow(ResultSet rs, int rowNum) throws SQLException {
        bookingDetailsForReceipt bookingDetailsForReceiptObject = new bookingDetailsForReceipt();
        bookingDetailsForReceiptObject.setBookingId(rs.getString(1));
        bookingDetailsForReceiptObject.setBookingDate(rs.getObject(2, LocalDateTime.class));
        bookingDetailsForReceiptObject.setPickupLocation(rs.getString(3));
        bookingDetailsForReceiptObject.setDestination(rs.getString(4));
        bookingDetailsForReceiptObject.setVehicleType(rs.getString(5));
        bookingDetailsForReceiptObject.setCustomerId(rs.getString(6));
        bookingDetailsForReceiptObject.setFirstName(rs.getString(7));
        bookingDetailsForReceiptObject.setLastName(rs.getString(8));
        bookingDetailsForReceiptObject.setMessage(1);

        return bookingDetailsForReceiptObject;
    }
}

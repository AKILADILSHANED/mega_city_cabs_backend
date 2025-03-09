package com.mega_city_cabs.mega_city_cabs.SqlMappers;

import com.mega_city_cabs.mega_city_cabs.DTO.receiptReportDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class receiptReportMapper implements RowMapper<receiptReportDTO> {

    @Override
    public receiptReportDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        receiptReportDTO receiptObject = new receiptReportDTO();

        receiptObject.setReceiptNumber(rs.getString(1));
        receiptObject.setReceiptDate(rs.getObject(2, LocalDateTime.class));
        receiptObject.setPaymentType(rs.getString(3));
        receiptObject.setFare(rs.getDouble(4));
        receiptObject.setTaxRate(rs.getDouble(5));
        receiptObject.getAdmin(rs.getString(6));
        receiptObject.getCustomer(rs.getString(7));

        return receiptObject;
    }
}

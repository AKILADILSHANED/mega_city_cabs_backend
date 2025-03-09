package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.DTO.bookingDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.customerDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.receiptReportDTO;
import com.mega_city_cabs.mega_city_cabs.Entity.customer;
import com.mega_city_cabs.mega_city_cabs.SqlMappers.bookingDetailsMapper;
import com.mega_city_cabs.mega_city_cabs.SqlMappers.customerDetailsMapper;
import com.mega_city_cabs.mega_city_cabs.SqlMappers.receiptReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reportIMPL implements reports{

    @Autowired
    JdbcTemplate template;

    @Override
    public List<customerDTO> getCustomerReport() {
        String Sql = "SELECT * FROM customer";
        return template.query(Sql, new customerDetailsMapper());
    }

    @Override
    public List<bookingDTO> getBookingReport() {
        String Sql = "SELECT * FROM booking";
        return template.query(Sql, new bookingDetailsMapper());
    }

    @Override
    public List<receiptReportDTO> getReceiptReport() {
        String Sql = "SELECT rec.receipt_number, rec.receipt_date, rec.payment_type, rec.fare, rec.tax_rate, ad.first_name AS 'Admin', cus.first_name AS 'Customer' FROM receipt rec LEFT JOIN administrator ad ON rec.admin_id = ad.admin_id LEFT JOIN customer cus ON cus.customer_id = rec.customer_id";
        return template.query(Sql, new receiptReportMapper());
    }
}

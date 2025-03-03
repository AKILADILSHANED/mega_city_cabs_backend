package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.DTO.bookingDetailsForReceipt;
import com.mega_city_cabs.mega_city_cabs.DTO.receiptDTO;
import com.mega_city_cabs.mega_city_cabs.Entity.customer;
import com.mega_city_cabs.mega_city_cabs.Entity.receipt;
import com.mega_city_cabs.mega_city_cabs.Repository.adminRepo;
import com.mega_city_cabs.mega_city_cabs.Repository.bookingRepo;
import com.mega_city_cabs.mega_city_cabs.Repository.customerRepo;
import com.mega_city_cabs.mega_city_cabs.Repository.receiptRepository;
import com.mega_city_cabs.mega_city_cabs.SqlMappers.customerMapper;
import com.mega_city_cabs.mega_city_cabs.SqlMappers.getBookingDetailsForReceiptMapper;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class receiptIMPL implements receiptService{

    @Autowired
    receiptRepository receiptRepo;

    @Autowired
    adminRepo admin;

    @Autowired
    bookingRepo booking;

    @Autowired
    HttpSession session;

    @Autowired
    JdbcTemplate template;

    @Autowired
    customerRepo customerObject;


    @Transactional
    @Override
    public String issueReceipt(receiptDTO receiptDto) {

        String newReceiptNumber = null;
        //Generate Receipt Number.
        try{
            String lastReceipt = receiptRepo.getLastReceiptNumber();
            if(lastReceipt == null){
                newReceiptNumber = "RCPT00001";
            }else{
                int newNumericPart = Integer.parseInt(lastReceipt.replace("RCPT", "")) + 1;
                newReceiptNumber = String.format("RCPT%05d", newNumericPart);
            }
        }catch (Exception e){
            return "An error occurred fetching receipt number. Please contact administrator!";
        }
        try{
            receipt receiptObject = new receipt(
                    newReceiptNumber,
                    LocalDateTime.now(),
                    receiptDto.getPaymentType(),
                    receiptDto.getTaxRate(),
                    receiptDto.getFare(),
                    admin.findById(session.getAttribute("admin_id").toString()).get(),
                    customerObject.findById(receiptDto.getCustomerId()).get(),
                    booking.findById(receiptDto.getBookingId()).get()
            );
            receiptRepo.save(receiptObject);
            return "Receipt issued successfully!";

        }catch(Exception e){
            return e.getMessage();
            //return "An error occurred while updating receipt data. Please contact administrator!";
        }
    }

    @Override
    public bookingDetailsForReceipt getBookingDetailsForReceipt(String bookingId) {
        try{
            String Sql = "SELECT BK.booking_id, BK.booking_date, BK.pickup_location, BK.destination, BK.vehicle_type,CUS.customer_id, CUS.first_name, CUS.last_name FROM booking BK LEFT JOIN customer CUS ON BK.customer_id = CUS.customer_id WHERE BK.booking_id = ?";
            List<bookingDetailsForReceipt> bookingDetailsForReceiptObj = template.query(Sql, new getBookingDetailsForReceiptMapper(), new Object[]{bookingId});
            if(bookingDetailsForReceiptObj.isEmpty()){
                bookingDetailsForReceipt nullResult = new bookingDetailsForReceipt(
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        0 // No record for provided booking ID.
                );
                return nullResult;
            }else{
                return bookingDetailsForReceiptObj.get(0);
            }

        }catch (Exception e){
            bookingDetailsForReceipt result = new bookingDetailsForReceipt(
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    2 // Exception occur
            );
            return result;
        }
    }
}

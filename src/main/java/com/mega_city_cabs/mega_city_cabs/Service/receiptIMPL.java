package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.DTO.bookingDetailsForReceipt;
import com.mega_city_cabs.mega_city_cabs.DTO.receiptConfirmDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.receiptDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.receiptPrintDTO;
import com.mega_city_cabs.mega_city_cabs.Entity.booking;
import com.mega_city_cabs.mega_city_cabs.Entity.customer;
import com.mega_city_cabs.mega_city_cabs.Entity.receipt;
import com.mega_city_cabs.mega_city_cabs.ExceptionsHandling.*;
import com.mega_city_cabs.mega_city_cabs.Repository.adminRepo;
import com.mega_city_cabs.mega_city_cabs.Repository.bookingRepo;
import com.mega_city_cabs.mega_city_cabs.Repository.customerRepo;
import com.mega_city_cabs.mega_city_cabs.Repository.receiptRepository;
import com.mega_city_cabs.mega_city_cabs.SqlMappers.getBookingDetailsForReceiptMapper;
import com.mega_city_cabs.mega_city_cabs.SqlMappers.receiptDetailsMapper;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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
    bookingRepo booking_repo;

    @Autowired
    HttpSession session;

    @Autowired
    JdbcTemplate template;

    @Autowired
    customerRepo customerObject;


    @Transactional
    @Override
    public receiptConfirmDTO issueReceipt(receiptDTO receiptDto) {
        String newReceiptNumber;
        customer customerObj;
        booking bookingObj;

        //Generate Receipt Number.
        try{
            if(receiptDto.getFare() == null || receiptDto.getTaxRate() == null || receiptDto.getPaymentType() == null){
                throw new nullReceiptIDFound("Receipt details can not be null. Please provide valid data!");
            }else{
                String lastReceipt = receiptRepo.getLastReceiptNumber();
                if(lastReceipt == null){
                    newReceiptNumber = "RCPT00001";
                }else{
                    int newNumericPart = Integer.parseInt(lastReceipt.replace("RCPT", "")) + 1;
                    newReceiptNumber = String.format("RCPT%05d", newNumericPart);
                }
                //Getting Customer Object and Booking Object.

                //Get customer object
                customerObj = customerObject.getCustomerObject(receiptDto.getCustomerId());
                if(customerObj == null){
                    throw new customerNotFoundException("Customer not found!");
                }else{
                    bookingObj = booking_repo.getBookingObject(receiptDto.getBookingId());
                    if(bookingObj == null){
                        throw new bookingNotFoundException("Booking not found!");
                    }
                }
                receipt receiptObject = new receipt(
                        newReceiptNumber,
                        LocalDateTime.now(),
                        receiptDto.getPaymentType(),
                        receiptDto.getTaxRate(),
                        0,
                        receiptDto.getFare(),
                        admin.findById(session.getAttribute("admin_id").toString()).get(),
                        customerObj,
                        bookingObj
                );
                receiptRepo.save(receiptObject);
                return new receiptConfirmDTO(
                        newReceiptNumber,
                        "Receipt Issued Successfully with Receipt Number: " + newReceiptNumber
                );
            }
        }catch (nullReceiptIDFound e){
            return new receiptConfirmDTO(
                    null,
                    e.getMessage()
            );
        }catch(customerNotFoundException e){
             return new receiptConfirmDTO(
                     null,
                     e.getMessage()
             );
        }catch (bookingNotFoundException e){
            return new receiptConfirmDTO(
                    null,
                    e.getMessage()
            );
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

    @Override
    public receiptPrintDTO getReceiptDetails(String receiptNumber) {
        try{

            String Sql = "SELECT rec.receipt_number, rec.receipt_date, rec.payment_type,rec.tax_rate, rec.fare, rec.customer_id, rec.booking_id, rec.admin_id, bk.pickup_location, bk.destination FROM receipt rec LEFT JOIN booking bk ON rec.booking_id = bk.booking_id WHERE rec.receipt_number = ?";
            List<receiptPrintDTO> receiptDetailsList = template.query(Sql, new receiptDetailsMapper(),new Object[]{receiptNumber});
            receiptPrintDTO receiptDetailObject = receiptDetailsList.get(0);
            if(receiptDetailObject != null){
                //Calculate VAT amount.
                double VatAmount = Math.round(receiptDetailObject.getFare() * ((double) receiptDetailObject.getTaxRate() /100));
                double serviceCharge = Math.round(receiptDetailObject.getFare() * ((double) 10 /100));
                double totalDue = Math.round(receiptDetailObject.getFare() + VatAmount + serviceCharge);

                receiptDetailObject.setVatAmount(VatAmount);
                receiptDetailObject.setServiceCharge(serviceCharge);
                receiptDetailObject.setTotalDue(totalDue);

                return receiptDetailObject;
            }else{
                throw new receiptDetailsNotFoundException("No receipt details found!");
            }
        }catch(receiptDetailsNotFoundException e){
                return new receiptPrintDTO(
                        null,
                        null,
                        null,
                        0,
                        0,
                        null,
                        null,
                        null,
                        0,
                        0,
                        0,
                        null,
                        null,
                        e.getMessage()
                );
        }

    }

    @Override
    public receiptPrintDTO receiptReprint(String receiptNumber) {
        System.out.println(receiptNumber);
        try{
            if(receiptNumber == null){
                throw new nullReceiptIDFound("Receipt number is null. Please provide valid Receipt number!");
            }else{
                Integer deleteStatus = receiptRepo.checkReceiptDeletionStatus(receiptNumber);
                if(deleteStatus == null){
                    throw new receiptDetailsNotFoundException("");
                }
                if(deleteStatus == 1){
                    throw new receiptDeletedException("");
                }
                else{
                    String Sql = "SELECT rec.receipt_number, rec.receipt_date, rec.payment_type,rec.tax_rate, rec.fare, rec.customer_id, rec.booking_id, rec.admin_id, bk.pickup_location, bk.destination FROM receipt rec LEFT JOIN booking bk ON rec.booking_id = bk.booking_id WHERE rec.receipt_number = ?";
                    List<receiptPrintDTO> receiptDetailsList = template.query(Sql, new receiptDetailsMapper(),new Object[]{receiptNumber});

                    if(!receiptDetailsList.isEmpty()){
                        receiptPrintDTO receiptDetailObject = receiptDetailsList.get(0);
                        //Calculate VAT amount.
                        double VatAmount = Math.round(receiptDetailObject.getFare() * ((double) receiptDetailObject.getTaxRate() /100));
                        double serviceCharge = Math.round(receiptDetailObject.getFare() * ((double) 10 /100));
                        double totalDue = Math.round(receiptDetailObject.getFare() + VatAmount + serviceCharge);

                        receiptDetailObject.setVatAmount(VatAmount);
                        receiptDetailObject.setServiceCharge(serviceCharge);
                        receiptDetailObject.setTotalDue(totalDue);

                        return receiptDetailObject;
                    }else{
                        throw new receiptDetailsNotFoundException("No receipt details found!");
                    }
                }
            }

        }catch (nullReceiptIDFound e){
            return new receiptPrintDTO(
                    null,
                    null,
                    null,
                    0,
                    0,
                    null,
                    null,
                    null,
                    0,
                    0,
                    0,
                    null,
                    null,
                    e.getMessage()
            );
        }
        catch(receiptDetailsNotFoundException e){
            return new receiptPrintDTO(
                    null,
                    null,
                    null,
                    0,
                    0,
                    null,
                    null,
                    null,
                    0,
                    0,
                    0,
                    null,
                    null,
                    e.getMessage()
            );
        }catch (receiptDeletedException e){
            return new receiptPrintDTO(
                    null,
                    null,
                    null,
                    0,
                    0,
                    null,
                    null,
                    null,
                    0,
                    0,
                    0,
                    null,
                    null,
                    e.getMessage()
            );
        }
    }

    @Transactional
    @Override
    public String deleteReceipt(String receiptNumber) {
        try{
            if(receiptNumber == null){
                throw new nullReceiptIDFound("Receipt number is null. Please provide valid receipt id!");
            }else{
                //Check whether the receipt is already deleted or not.
                Integer deleteStatus = receiptRepo.checkReceiptDeletionStatus(receiptNumber);
                if(deleteStatus == null){
                    throw new receiptDetailsNotFoundException("");
                }
                if(deleteStatus == 0){
                    int affectedRows = receiptRepo.deleteReceipt(receiptNumber);
                    return "Receipt number " + receiptNumber + " deleted successfully!";
                }else{
                    throw new receiptDeletedException("");
                }
            }
        }catch (receiptDetailsNotFoundException e){
            return "No receipt details found for provided Receipt NUmber!";
        }catch (receiptDeletedException e){
            return "This receipt number is already deleted!";
        }catch (nullReceiptIDFound e){
            return e.getMessage();
        }
    }
}

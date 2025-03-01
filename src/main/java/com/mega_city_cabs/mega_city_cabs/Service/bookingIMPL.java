package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.DTO.cancelBookingDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.newBookingDTO;
import com.mega_city_cabs.mega_city_cabs.Entity.booking;
import com.mega_city_cabs.mega_city_cabs.Repository.adminRepo;
import com.mega_city_cabs.mega_city_cabs.Repository.bookingRepo;
import com.mega_city_cabs.mega_city_cabs.Repository.customerRepo;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class bookingIMPL implements customerBooking {

    @Autowired
    bookingRepo bookingRepository;

    @Autowired
    HttpSession session;

    @Autowired
    customerRepo customerRepository;

    @Autowired
    adminRepo admin;

    @Transactional
    @Override
    public String newBooking(newBookingDTO newBooking) {

        String newBookingId;

        try{
            //Generate new booking id.
            String lastBookingIdFromTable = bookingRepository.getLastBookingId();
            if(lastBookingIdFromTable == null){
                newBookingId = "BK00001";
            }else{
                int newNumericId = Integer.parseInt(lastBookingIdFromTable.replace("BK", "")) + 1;
                newBookingId = String.format("BK%05d", newNumericId);
            }
        }catch (Exception e){
            return e.getMessage();
        }

        if(session.getAttribute("customer_id") == null){
            return "Please log in to the system again!";
        }else{
            try{
                booking bookingObj = new booking(
                        newBookingId,
                        newBooking.getPickupLocation(),
                        newBooking.getDestination(),
                        LocalDateTime.now(),
                        newBooking.getVehicleType(),
                        "Online",
                        0,
                        customerRepository.getCustomerObject(session.getAttribute("customer_id").toString()),
                        null
                );
                bookingRepository.save(bookingObj);
                return "Booking request is completed successfully with Booking ID: " + newBookingId + "!";
            }catch (Exception e){
                //return "An error occurred while initiating the booking. Please try again later!";
                return e.getMessage();
            }
        }

    }

    @Override
    public cancelBookingDTO displayBookingForCancel(String bookingId) {
        try{
            booking bookingObj = bookingRepository.checkBooking(session.getAttribute("customer_id").toString(),bookingId);
            if(bookingObj != null){
                if(bookingObj.getConfirmBy() != null){
                    return new cancelBookingDTO(
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            "This booking is already approved. Please contact us to cancel booking!"
                    );
                }else{
                    if(bookingObj.getIsCancelled() == 1){
                        return new cancelBookingDTO(
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                "This booking is already canceled!"
                        );
                    }else{
                        return new cancelBookingDTO(
                                bookingObj.getBookingId(),
                                bookingObj.getPickupLocation(),
                                bookingObj.getDestination(),
                                bookingObj.getBookingDate(),
                                bookingObj.getVehicleType(),
                                bookingObj.getBookingType(),
                                null
                        );
                    }
                }
            }else{
                return new cancelBookingDTO(
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        "No booking details found for provided Booking ID!"
                );
            }
        }catch (Exception e){
            return new cancelBookingDTO(
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    e.getMessage()
            );
        }
    }

    @Transactional
    @Override
    public String cancelBooking(String bookingId) {
        try{
            int affected_rows = bookingRepository.cancelBooking(bookingId);
            if(affected_rows > 0){
                return "Your booking was canceled successfully!";
            }else {
                return "";
            }
        }catch (Exception e){
            return e.getMessage();
        }
    }
}

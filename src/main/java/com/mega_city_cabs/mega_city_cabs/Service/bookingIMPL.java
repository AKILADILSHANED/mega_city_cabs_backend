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
                return "Booking request is completed successfully!";
            }catch (Exception e){
                //return "An error occurred while initiating the booking. Please try again later!";
                return e.getMessage();
            }
        }

    }

    @Override
    public cancelBookingDTO displayBookingForCancel(String bookingId) {
        booking bookingObj = bookingRepository.findById(bookingId).get();
        cancelBookingDTO cancelBookingObj = new cancelBookingDTO(
                bookingObj.getBookingId(),
                bookingObj.getPickupLocation(),
                bookingObj.getDestination(),
                bookingObj.getBookingDate(),
                bookingObj.getVehicleType(),
                bookingObj.getBookingType()
        );
        return cancelBookingObj;
    }

    @Transactional
    @Override
    public String cancelBooking(String bookingId) {
        String returnMessage = null;
        try{
            booking approval = bookingRepository.checkBookingApproval(bookingId);
            if(approval.getConfirmBy() == null && approval.getIsCancelled() == 0){
                try{
                    int affectedRow = bookingRepository.cancelBooking(bookingId);
                    returnMessage = "Booking cancelled successfully!";
                }catch (Exception e){
                    returnMessage = e.getMessage();
                }
            }else if(approval.getConfirmBy() == null && approval.getIsCancelled() == 1){
                returnMessage = "This booking is already Cancelled!";
            }else if(approval.getConfirmBy() != null){
                returnMessage = "This booking is already approved. Please contact us for cancellation!";
            }
        }catch (Exception e){
            returnMessage = e.getMessage();
        }
        return returnMessage;
    }
}

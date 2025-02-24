package com.mega_city_cabs.mega_city_cabs.Service;

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

        String lastBookingId;
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

        try{
            booking bookingObj = new booking(
                    newBookingId,
                    newBooking.getPickupLocation(),
                    newBooking.getDestination(),
                    LocalDateTime.now(),
                    "Car",
                    "Online",
                    customerRepository.findById(session.getAttribute("customer_id").toString()).get(),
                    admin.findById("ADMN001").get()
            );
            bookingRepository.save(bookingObj);
            return "Booking request is completed successfully!";
        }catch (Exception e){
            return e.getMessage();
        }
    }
}

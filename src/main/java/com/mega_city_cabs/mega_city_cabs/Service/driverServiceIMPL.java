package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.DTO.*;
import com.mega_city_cabs.mega_city_cabs.Entity.DriverAssignment;
import com.mega_city_cabs.mega_city_cabs.Entity.administrator;
import com.mega_city_cabs.mega_city_cabs.Entity.booking;
import com.mega_city_cabs.mega_city_cabs.Entity.driver;
import com.mega_city_cabs.mega_city_cabs.Repository.adminRepo;
import com.mega_city_cabs.mega_city_cabs.Repository.bookingRepo;
import com.mega_city_cabs.mega_city_cabs.Repository.driverAssignmentRepo;
import com.mega_city_cabs.mega_city_cabs.Repository.driverRepo;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class driverServiceIMPL implements driverService{

    @Autowired
    driverRepo driverRepository;

    @Autowired
    driverAssignmentRepo driverAssignment;

    @Autowired
    HttpSession session;

    @Autowired
    adminRepo administratorRepo;

    @Autowired
    bookingRepo booking;

    @Override
    public String registerDriver(driverRegisterDTO driverRegister) {

        String newLastDriverId;

        //Generate Driver ID.
        try{
            String lastDriverId = driverRepository.getLastDriverId();
            if(lastDriverId == null){
                newLastDriverId = "DVR001";
            }else{
                int numericPart =  Integer.parseInt(lastDriverId.replace("DVR", "")) + 1;
                newLastDriverId = String.format("DVR%03d", numericPart);
            }
        }catch(Exception e){
                return e.getMessage();
        }

        //Update data for driver entity to save in driver table
        driver driverObj = new driver(
                newLastDriverId,
                driverRegister.getFirstName(),
                driverRegister.getLastName(),
                driverRegister.getContactNumber(),
                driverRegister.getNic(),
                LocalDateTime.now(),
                0,
                administratorRepo.findById("ADMN001").get()
        );

        //Save driver details to driver table.

        try{
            driverRepository.save(driverObj);
            return "Driver registered successfully with Driver ID: " + newLastDriverId + "!";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public driverSearchDTO driverSearch(String driverId) {

        try{
            //Check any record available for provided driver id.
            Optional<driver> searchedDriver =  driverRepository.findById(driverId);
            if(searchedDriver.isEmpty()){
                return new driverSearchDTO(
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        "No driver details found for provided Driver ID!"
                );
            }else{

                if(searchedDriver.get().getIsDeleted() == 1){
                    return new driverSearchDTO(
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            "This driver is already removed!"
                    );
                }else{
                    return new driverSearchDTO(
                            searchedDriver.get().getDriverId(),
                            searchedDriver.get().getFirstName(),
                            searchedDriver.get().getLastName(),
                            searchedDriver.get().getContactNumber(),
                            searchedDriver.get().getNic(),
                            searchedDriver.get().getRegisteredDate(),
                            null
                    );
                }
            }
        }catch (Exception e){
            return new driverSearchDTO(
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    "An Error occurred. Please contact administrator!"
            );
        }
    }

    @Transactional
    @Override
    public String driverUpdate(driverUpdateDTO driverUpdate) {
        try {
            int affectedRows = driverRepository.driverUpdate(
                    driverUpdate.getFirstName(),
                    driverUpdate.getLastName(),
                    driverUpdate.getContactNumber(),
                    driverUpdate.getNic(),
                    driverUpdate.getDriverId()
            );

            if (affectedRows > 0) {
                return "Driver details updated successfully!";
            } else {
                return "No record found for provided Driver ID!";
            }
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Transactional
    @Override
    public String removeDriver(String driverId) {
        try{
            int affectedRows = driverRepository.removeDriver(driverId);
            if(affectedRows > 0){
                return "Driver removed successfully!";
            }else{
                return "No driver details found for provided Driver ID!";
            }
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public List<driverDataForAssignDTO> getDriverDataForAssign() {
        List<driver> driverList = driverRepository.getDriverDataForAssign();
        List<driverDataForAssignDTO> driverDataList = new ArrayList<>();
        for (driver driverObj : driverList){
            driverDataForAssignDTO newObjectDriver = new driverDataForAssignDTO(
                    driverObj.getDriverId(),
                    driverObj.getFirstName(),
                    driverObj.getLastName()
            );
            driverDataList.add(newObjectDriver);
        }
        return driverDataList;
    }

    @Transactional
    @Override
    public String assignDriver(String driverId, String bookingId) {

        String newAssignmentId = null;

        //Get last assignment id form driver assignment table.
        String lastAssignmentId = driverAssignment.getLastDriverAssignmentId();
        if(lastAssignmentId == null){
            newAssignmentId = "DASGN00001";
        }else{
            int newNumericId = Integer.parseInt(lastAssignmentId.replace("DASGN", "")) + 1 ;
            newAssignmentId = String.format("DASGN%05d", newNumericId);
        }

        try{
            String sessionAdmin = session.getAttribute("admin_id").toString();
            driver driverObject = driverRepository.findById(driverId).get();
            
            administrator adminObject = administratorRepo.findById(sessionAdmin).get();
            booking bookingObject = booking.findById(bookingId).get();

            DriverAssignment assignment = new DriverAssignment(
                    newAssignmentId,
                    LocalDateTime.now(),
                    adminObject,
                    driverObject,
                    bookingObject
            );
            driverAssignment.save(assignment);
            return "Driver assigned successfully with Assignment ID: " + newAssignmentId + " for BookingID: " + bookingId;
        }catch (Exception e){
            return "An error occurred while assigning the driver. Please contact administrator!";
        }
    }
}

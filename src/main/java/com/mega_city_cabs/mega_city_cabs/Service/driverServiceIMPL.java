package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.DTO.driverRegisterDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.driverSearchDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.driverUpdateDTO;
import com.mega_city_cabs.mega_city_cabs.Entity.driver;
import com.mega_city_cabs.mega_city_cabs.Repository.adminRepo;
import com.mega_city_cabs.mega_city_cabs.Repository.driverRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class driverServiceIMPL implements driverService{

    @Autowired
    driverRepo driverRepository;

    @Autowired
    adminRepo administratorRepo;

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
}

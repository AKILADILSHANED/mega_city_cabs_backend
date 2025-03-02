package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.DTO.registerVehicleDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.vehicleDataForAssignDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.vehicleSearchDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.vehicleUpdateDTO;
import com.mega_city_cabs.mega_city_cabs.Entity.*;
import com.mega_city_cabs.mega_city_cabs.Repository.adminRepo;
import com.mega_city_cabs.mega_city_cabs.Repository.bookingRepo;
import com.mega_city_cabs.mega_city_cabs.Repository.vehicleAssignmentRepo;
import com.mega_city_cabs.mega_city_cabs.Repository.vehicleRepo;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class vehicleServiceIMPL implements vehicleService{

    Optional<administrator> admin;


    @Autowired
    private vehicleRepo vehiclerepository;
    @Autowired
    private adminRepo adminRepository;
    @Autowired
    vehicleAssignmentRepo vehicleAssignment;
    @Autowired
    HttpSession session;
    @Autowired
    vehicleRepo vehicleRepository;
    @Autowired
    adminRepo administratorRepo;
    @Autowired
    bookingRepo booking;

    @Override
    public String registerVehicle(registerVehicleDTO registerVehicleDTO) {
        String vehicleId;
        //Get last vehicle id from vehicle table
        try{
            String lastVehicleId = vehiclerepository.getLastVehicleID();
            if(lastVehicleId == null){
                vehicleId = "VH001";
            }else{
                int numericValue = Integer.parseInt(lastVehicleId.replace("VH", ""));
                String incrementedVehicleId = String.format("VH%03d", numericValue+1);
                vehicleId = incrementedVehicleId;
            }
        }catch (Exception e){
            return e.getMessage();
        }

        //Get admin reference form database..
        try{
            admin = adminRepository.findById("ADMN001");
        }catch (Exception e){
            return e.getMessage();
        }

        //Create vehicle entity using the constructor.

        vehicle registerVehicle = new vehicle(
                vehicleId,
                registerVehicleDTO.getVehicleNumber(),
                registerVehicleDTO.getVehicleType(),
                registerVehicleDTO.getVehicleModel(),
                LocalDateTime.now(),
                0,
                admin.get()
        );
        try{
            vehiclerepository.save(registerVehicle);
            return "Vehicle registered successfully with Vehicle ID: " + vehicleId;
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public vehicleSearchDTO vehicleSearch(String vehicleId) {
        try{
            Optional<vehicle> vehicleSearch = vehiclerepository.findById(vehicleId);

            if(vehicleSearch.get().getDeleteStatus() == 1){
                return null;
            }else{
                vehicleSearchDTO vehicleSearchObject = new vehicleSearchDTO(
                        vehicleSearch.get().getVehicleId(),
                        vehicleSearch.get().getVehicleNumber(),
                        vehicleSearch.get().getVehicleType(),
                        vehicleSearch.get().getVehicleModel(),
                        vehicleSearch.get().getRegisteredDate(),
                        vehicleSearch.get().getAdmin()
                );
                return vehicleSearchObject;
            }

        }catch (Exception e){
            return null;
        }
    }

    @Override
    public String updateVehicle(vehicleUpdateDTO vehicleUpdate) {
        try{
            int affectedRows = vehiclerepository.updateVehicleDetails(
                    vehicleUpdate.getVehicleNumber(),
                    vehicleUpdate.getVehicleType(),
                    vehicleUpdate.getVehicleModel(),
                    vehicleUpdate.getVehicleId()
            );
            if(affectedRows > 0){
                return "Vehicle details successfully updated for Vehicle ID: " + vehicleUpdate.getVehicleId() + "!";
            }else{
                return "No vehicle details found for Vehicle ID: " + vehicleUpdate.getVehicleId() + "!";
            }
        }catch (Exception e){
            return "Error in updating vehicle details. Please contact administrator!";
        }
    }

    @Override
    public String deleteVehicle(String vehicleId) {
        try{
            int affectedRow = vehiclerepository.deleteVehicle(vehicleId);
            if(affectedRow > 0){
                return "Vehicle ID: " + vehicleId + " deleted successfully!";
            }else{
                return "No record found for Vehicle ID: " + vehicleId;
            }
        }catch (Exception e){
            return "Error in deleting vehicle details. Please contact administrator!";
        }
    }

    @Override
    public List<vehicleDataForAssignDTO> assignVehicleData() {
        List<vehicle> vehicles = vehiclerepository.vehicleList();
        List<vehicleDataForAssignDTO> vehicleAssignList = new ArrayList<>();
        for(vehicle v : vehicles){
            vehicleDataForAssignDTO vehicleData = new vehicleDataForAssignDTO(
                    v.getVehicleId(),
                    v.getVehicleNumber()
            );
            vehicleAssignList.add(vehicleData);
        }
        return vehicleAssignList;
    }

    @Transactional
    @Override
    public String assignVehicle(String vehicleId, String bookingId) {
        String newAssignmentId = null;

        //Get last assignment id form vehicle assignment table.
        String lastAssignmentId = vehicleAssignment.getLastVehicleAssignmentId();
        if(lastAssignmentId == null){
            newAssignmentId = "VASGN00001";
        }else{
            int newNumericId = Integer.parseInt(lastAssignmentId.replace("VASGN", "")) + 1 ;
            newAssignmentId = String.format("VASGN%05d", newNumericId);
        }

        try{
            String sessionAdmin = session.getAttribute("admin_id").toString();
            vehicle vehicleObject = vehicleRepository.findById(vehicleId).get();

            administrator adminObject = administratorRepo.findById(sessionAdmin).get();
            booking bookingObject = booking.findById(bookingId).get();

            VehicleAssignment assignment = new VehicleAssignment(
                    newAssignmentId,
                    LocalDateTime.now(),
                    adminObject,
                    vehicleObject,
                    bookingObject
            );
            vehicleAssignment.save(assignment);
            return "Vehicle assigned successfully with Assignment ID: " + newAssignmentId + " for BookingID: " + bookingId;
        }catch (Exception e){
            return e.getMessage();
            //return "An error occurred while assigning the vehicle. Please contact administrator!";
        }
    }
}

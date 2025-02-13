package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.DTO.registerVehicleDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.vehicleSearchDTO;
import com.mega_city_cabs.mega_city_cabs.Entity.administrator;
import com.mega_city_cabs.mega_city_cabs.Entity.vehicle;
import com.mega_city_cabs.mega_city_cabs.Repository.adminRepo;
import com.mega_city_cabs.mega_city_cabs.Repository.vehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class vehicleServiceIMPL implements vehicleService{

    Optional<administrator> admin;


    @Autowired
    private vehicleRepo vehiclerepository;
    @Autowired
    private adminRepo adminRepository;

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




    Optional<vehicle> vehicle;

    @Override
    public vehicleSearchDTO vehicleSearch(String vehicleId) {
        try{
            vehicle = vehiclerepository.findById(vehicleId);
            vehicle vehicleEntity = vehicle.get();

            if(vehicleEntity == null){
                return null;
            }else{
                vehicleSearchDTO vehicleSearch = new vehicleSearchDTO(
                        vehicleEntity.getVehicleId(),
                        vehicleEntity.getVehicleNumber(),
                        vehicleEntity.getVehicleType(),
                        vehicleEntity.getVehicleModel(),
                        vehicleEntity.getRegisteredDate(),
                        vehicleEntity.getAdmin()
                );
                return vehicleSearch;
            }

        }catch (Exception e){
            return null;
        }
    }
}

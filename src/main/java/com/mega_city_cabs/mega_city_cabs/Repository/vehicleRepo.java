package com.mega_city_cabs.mega_city_cabs.Repository;

import com.mega_city_cabs.mega_city_cabs.Entity.vehicle;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface vehicleRepo extends JpaRepository<vehicle,String> {

    @Query(value = "SELECT vehicle_id FROM vehicle ORDER BY registered_date DESC LIMIT 1", nativeQuery = true)
    public String getLastVehicleID();

    @Modifying
    @Transactional
    @Query(value = "UPDATE vehicle SET vehicle_number = ?1, vehicle_type = ?2, vehicle_model = ?3 WHERE vehicle_id = ?4", nativeQuery = true)
    public int updateVehicleDetails(String vehicleNumber, String vehicleType, String vehicleModel, String vehicleId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE vehicle SET is_deleted = 1 WHERE vehicle_id = ?1", nativeQuery = true)
    public int deleteVehicle(String vehicleId);

    @Query(value = "SELECT * FROM `vehicle` WHERE is_deleted = 0", nativeQuery = true)
    public List<vehicle> vehicleList();
}

package com.mega_city_cabs.mega_city_cabs.Repository;

import com.mega_city_cabs.mega_city_cabs.Entity.vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface vehicleRepo extends JpaRepository<vehicle,String> {

    @Query(value = "SELECT vehicle_id FROM vehicle ORDER BY registered_date DESC LIMIT 1", nativeQuery = true)
    public String getLastVehicleID();

}

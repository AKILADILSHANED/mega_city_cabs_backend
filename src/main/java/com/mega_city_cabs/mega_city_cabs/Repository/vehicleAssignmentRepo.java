package com.mega_city_cabs.mega_city_cabs.Repository;

import com.mega_city_cabs.mega_city_cabs.Entity.VehicleAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface vehicleAssignmentRepo extends JpaRepository<VehicleAssignment, String> {
    @Query(value = "SELECT assignment_id FROM vehicle_assignment ORDER BY assignment_date DESC LIMIT 1", nativeQuery = true)
    public String getLastVehicleAssignmentId();
}

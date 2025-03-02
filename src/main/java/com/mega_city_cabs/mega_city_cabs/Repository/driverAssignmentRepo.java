package com.mega_city_cabs.mega_city_cabs.Repository;

import com.mega_city_cabs.mega_city_cabs.Entity.DriverAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface driverAssignmentRepo extends JpaRepository<DriverAssignment, String> {

    @Query(value = "SELECT assignment_id FROM driver_assignment ORDER BY assignment_date DESC LIMIT 1", nativeQuery = true)
    public String getLastDriverAssignmentId();
}

package com.mega_city_cabs.mega_city_cabs.Repository;

import com.mega_city_cabs.mega_city_cabs.Entity.driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface driverRepo extends JpaRepository<driver,String> {

    @Query(value = "SELECT driver_id FROM driver ORDER BY registered_date DESC LIMIT 1", nativeQuery = true)
    public String getLastDriverId();
}

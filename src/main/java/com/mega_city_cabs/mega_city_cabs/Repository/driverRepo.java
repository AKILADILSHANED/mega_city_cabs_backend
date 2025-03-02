package com.mega_city_cabs.mega_city_cabs.Repository;

import com.mega_city_cabs.mega_city_cabs.Entity.driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface driverRepo extends JpaRepository<driver,String> {

    @Query(value = "SELECT driver_id FROM driver ORDER BY registered_date DESC LIMIT 1", nativeQuery = true)
    public String getLastDriverId();

    @Modifying
    @Query(value = "UPDATE driver SET first_name = ?1, last_name = ?2, contact = ?3, nic = ?4 WHERE driver_id = ?5", nativeQuery = true)
    public int driverUpdate(String first_name, String last_name, String contact, String nic, String driver_id);

    @Modifying
    @Query(value = "UPDATE driver SET is_deleted = 1 WHERE driver_id = ?1", nativeQuery = true)
    public int removeDriver(String driverId);

    @Query(value = "SELECT * FROM driver", nativeQuery = true)
    public List<driver> getDriverDataForAssign();
}

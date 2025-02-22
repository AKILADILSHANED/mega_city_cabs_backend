package com.mega_city_cabs.mega_city_cabs.Repository;

import com.mega_city_cabs.mega_city_cabs.Entity.CustomerRegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface registrationRequestRepo extends JpaRepository<CustomerRegistrationRequest, String> {

    @Query(value = "SELECT request_id FROM registration_requests ORDER BY request_date DESC LIMIT 1", nativeQuery = true)
    public String lastRequestId();
}

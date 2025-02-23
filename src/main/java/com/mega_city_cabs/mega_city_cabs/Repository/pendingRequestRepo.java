package com.mega_city_cabs.mega_city_cabs.Repository;

import com.mega_city_cabs.mega_city_cabs.Entity.CustomerRegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface pendingRequestRepo extends JpaRepository<CustomerRegistrationRequest, String> {

    @Modifying
    @Query(value = "UPDATE registration_requests SET is_confirmed = 1, confirmed_date = ?1 WHERE customer_id = ?2", nativeQuery = true)
    public int approveRequest(LocalDateTime confirmed_date, String customer_id);

    @Modifying
    @Query(value = "UPDATE registration_requests SET is_confirmed = 2, confirmed_date = ?1 WHERE customer_id = ?2", nativeQuery = true)
    public int rejectRequest(LocalDateTime confirmed_date, String customer_id);
}

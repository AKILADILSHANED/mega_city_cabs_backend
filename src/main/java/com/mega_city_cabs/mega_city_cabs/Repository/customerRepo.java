package com.mega_city_cabs.mega_city_cabs.Repository;

import com.mega_city_cabs.mega_city_cabs.Entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface customerRepo extends JpaRepository<customer, String> {

    @Query(value = "SELECT customer_id FROM customer WHERE email = ?1 AND password = ?2", nativeQuery = true)
    public String searchLoginCustomer(String email, String password);

    @Query(value = "SELECT customer_id FROM customer ORDER BY customer_id DESC LIMIT 1", nativeQuery = true)
    public String getLastCustomerId();

    @Query(value = "SELECT * FROM customer WHERE customer_id = ?1", nativeQuery = true)
    public customer getCustomerObject(String customerId);
}

package com.mega_city_cabs.mega_city_cabs.Repository;

import com.mega_city_cabs.mega_city_cabs.Entity.receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface receiptRepository extends JpaRepository<receipt, String> {

    @Query(value = "SELECT receipt_number FROM receipt ORDER BY receipt_date DESC LIMIT 1", nativeQuery = true)
    public String getLastReceiptNumber();
}

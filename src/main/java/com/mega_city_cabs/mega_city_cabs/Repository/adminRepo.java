package com.mega_city_cabs.mega_city_cabs.Repository;

import com.mega_city_cabs.mega_city_cabs.Entity.administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface adminRepo extends JpaRepository<administrator, String> {

    @Query("SELECT COUNT(a) > 0 FROM administrator a WHERE a.loginId = :userName AND a.password = :password")
    boolean adminExistance(String userName, String password);

}

package com.mega_city_cabs.mega_city_cabs.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "Administrator")
public class administrator {
    @Id
    @Column(name = "admin_id", length = 7, nullable = false)
    private String adminId;

    @Column(name = "first_name", length = 10, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 10, nullable = false)
    private String lastName;

    @Column(name = "email", length = 50, nullable = false)
    private String enailAddress;

    @Column(name = "contact_number", length = 10, nullable = false)
    private  String contactNumber;

    @Column(name = "nic", length = 12, nullable = false)
    private String nic;

    @Column(name = "create_date", length = 20, nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "login_id", length = 10, nullable = false)
    private String loginId;

    @Column(name = "password", length = 10, nullable = false)
    private String password;

}

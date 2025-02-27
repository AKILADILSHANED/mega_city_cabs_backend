package com.mega_city_cabs.mega_city_cabs.Repository;

import com.mega_city_cabs.mega_city_cabs.Entity.booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface bookingRepo extends JpaRepository<booking, String> {

    @Query(value = "SELECT booking_id FROM booking ORDER BY booking_date DESC LIMIT 1", nativeQuery = true)
    public String getLastBookingId();

    @Query(value = "SELECT * from booking WHERE booking_id = ?1", nativeQuery = true)
    public booking checkBookingApproval(String bookingId);

    @Modifying
    @Query(value = "UPDATE booking SET is_cancelled = 1 WHERE booking_id = ?1", nativeQuery = true)
    public int cancelBooking(String bookingId);

}

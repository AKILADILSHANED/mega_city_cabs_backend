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

    @Query(value = "SELECT * FROM booking WHERE customer_id = ?1 AND booking_id = ?2", nativeQuery = true)
    public booking checkBooking(String customer_id, String bookingId);

    @Modifying
    @Query(value = "UPDATE booking SET is_cancelled = 1 WHERE booking_id = ?1", nativeQuery = true)
    public int cancelBooking(String bookingId);

    @Modifying
    @Query(value = "UPDATE booking SET approved_by = ?1 WHERE booking_id = ?2", nativeQuery = true)
    public int approveBooking(String admin, String bookingId);

    @Modifying
    @Query(value = "UPDATE booking SET is_cancelled = 2 WHERE booking_id = ?1", nativeQuery = true)
    public int rejectBooking(String bookingId);

}

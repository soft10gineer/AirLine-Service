package com.airline.AirlineService.Booking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingDtls, String>{

}

package com.airline.AirlineService.Booking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookingRepository extends JpaRepository<BookingDtls, String>{
	
	@Query("Select b from BookingDtls b where b.userId = :leadId") List<BookingDtls> findBookingByUserId (@Param("leadId") String LeadId );
}

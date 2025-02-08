package com.airline.AirlineService.Flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends JpaRepository<FlightDtls, Integer> {
	
	@Query("Select f from FlightDtls f where f.airFlightNumber = :flightNumber ") FlightDtls findByFlightNumber(@Param ("flightNumber") String flightNumber);

}

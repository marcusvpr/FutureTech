package com.mpxds.apps.repository;

import com.mpxds.apps.model.Flight;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    //

	Flight findByAirline(String airline);
	
	List<Flight> findAllByAirlineAndFromAirport(String airline, String FromAirport);
}
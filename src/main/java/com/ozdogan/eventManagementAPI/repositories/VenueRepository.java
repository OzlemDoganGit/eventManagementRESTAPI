package com.ozdogan.eventManagementAPI.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.ozdogan.eventManagement.entities.Venue;

public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {
	
	Page<Venue>findByPostalCode(@Param("postalCode") String postalCode, Pageable pageable);

}

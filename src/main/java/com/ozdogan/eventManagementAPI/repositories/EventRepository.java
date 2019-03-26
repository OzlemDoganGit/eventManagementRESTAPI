package com.ozdogan.eventManagementAPI.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.ozdogan.eventManagement.entities.Event;
import com.ozdogan.eventManagement.entities.projection.PartialEventProjection;

@RepositoryRestResource(excerptProjection=PartialEventProjection.class)
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
	
	Page <Event> findByName(@Param("name") String name, Pageable pageable);
	Page <Event> findByNameAndDescription(@Param("name") String name, @Param("description") String description, Pageable pageable);


	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	public void deleteById(Long id);

		
}

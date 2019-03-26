package com.ozdogan.eventManagementAPI.repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ozdogan.eventManagement.entities.Participant;
import com.ozdogan.eventManagement.entities.projection.PartialParticipantProjection;

@RepositoryRestResource(excerptProjection=PartialParticipantProjection.class)
public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long> {
	
	Page <Participant> findByEmail (@Param("email") String email, Pageable pageable);

}

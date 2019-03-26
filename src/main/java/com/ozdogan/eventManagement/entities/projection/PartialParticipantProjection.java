package com.ozdogan.eventManagement.entities.projection;

import org.springframework.data.rest.core.config.Projection;

import com.ozdogan.eventManagement.entities.Participant;

@Projection(name="partialInfoOfParticipant", types = {Participant.class})
public interface PartialParticipantProjection {
	
	
	public String getName() ;
	
	
	public Boolean getCheckedIn() ;

}

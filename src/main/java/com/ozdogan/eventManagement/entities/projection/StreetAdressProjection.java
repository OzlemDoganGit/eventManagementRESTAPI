package com.ozdogan.eventManagement.entities.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.ozdogan.eventManagement.entities.Venue;

@Projection(name = "virtual", types = { Venue.class })
public interface StreetAdressProjection {
	
	@Value("#{target.streetAddress} #{target.streetAddress2}")
	public String getCompleteStreetAddress();

}

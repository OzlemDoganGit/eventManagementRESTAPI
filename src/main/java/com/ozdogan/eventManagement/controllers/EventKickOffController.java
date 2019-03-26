package com.ozdogan.eventManagement.controllers;

import java.util.Optional;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozdogan.eventManagement.entities.Event;
import com.ozdogan.eventManagementAPI.repositories.EventRepository;

@RepositoryRestController
@RequestMapping("/events")
public class EventKickOffController {
	
	
	private final EventRepository eventRepository;
	
	
	public EventKickOffController(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}


	@PostMapping("/start/{id}")
	public ResponseEntity<String> start (@PathVariable Long id)
	{
		Optional <Event> eventOptional = eventRepository.findById(id);
		
		if (!eventOptional.isPresent())
		{
			throw new ResourceNotFoundException();
		}
		Event event = eventOptional.get();
		event.setStarted(true);
		eventRepository.save(event);
		return ResponseEntity.ok(event.getName() + " has started");
	}

}

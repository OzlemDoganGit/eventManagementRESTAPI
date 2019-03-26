package com.ozdogan.eventManagement.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozdogan.eventManagement.controllers.exceptions.AlreadyCheckedInException;
import com.ozdogan.eventManagement.controllers.exceptions.NotCheckedInException;
import com.ozdogan.eventManagement.entities.Participant;
import com.ozdogan.eventManagementAPI.repositories.ParticipantRepository;

@RepositoryRestController
@RequestMapping("/events")
public class CheckOutController {

	ParticipantRepository participantRepository;

	@Autowired
	public CheckOutController(ParticipantRepository participantRepository) {
		this.participantRepository = participantRepository;
	}

	@PostMapping("/checkOut/{id}")
	public ResponseEntity<PersistentEntityResource> checkOut(@PathVariable Long id, 
			PersistentEntityResourceAssembler assembler) {

		Optional<Participant> OptionalParticipant = participantRepository.findById(id);
		Participant participant = OptionalParticipant.get();

		if (OptionalParticipant.isPresent()) {

			if (!OptionalParticipant.get().getCheckedIn()) {
				throw new NotCheckedInException();
			}
			
			participant.setCheckedIn(false);
			participantRepository.save(participant);
		}

		return ResponseEntity.ok(assembler.toResource(participant));

	}

}

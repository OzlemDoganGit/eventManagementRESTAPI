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
import com.ozdogan.eventManagement.entities.Participant;
import com.ozdogan.eventManagementAPI.repositories.ParticipantRepository;

@RepositoryRestController
@RequestMapping("/events")
public class CheckInController {

	ParticipantRepository participantRepository;

	@Autowired
	public CheckInController(ParticipantRepository participantRepository) {
		this.participantRepository = participantRepository;
	}

	@PostMapping("/checkIn/{id}")
	public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id, 
			PersistentEntityResourceAssembler assembler) {

		Optional<Participant> OptionalParticipant = participantRepository.findById(id);
		Participant participant = OptionalParticipant.get();

		if (OptionalParticipant.isPresent()) {

			if (OptionalParticipant.get().getCheckedIn()) {
				throw new AlreadyCheckedInException();
			}
			
			participant.setCheckedIn(true);
			participantRepository.save(participant);
		}

		return ResponseEntity.ok(assembler.toResource(participant));

	}

}

package com.ozdogan.eventManagementAPI.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ozdogan.eventManagement.entities.Organizer;

public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long> {

}

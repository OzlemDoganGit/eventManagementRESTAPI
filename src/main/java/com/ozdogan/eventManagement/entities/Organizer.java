package com.ozdogan.eventManagement.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORGANIZER")
public class Organizer extends AbstractEntity {
	
	@Column(name="name")
	private String name;

	@OneToMany(mappedBy="organizer")
	private Set<Event> events;

	public Organizer() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	
	public Long getResourceId() {
		return this.id;
	}
	
	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Organizer) obj).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}

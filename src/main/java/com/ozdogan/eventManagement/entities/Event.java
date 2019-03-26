package com.ozdogan.eventManagement.entities;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"started"})
@Entity
@Table(name = "EVENT")
public class Event extends AbstractEntity {
	
	private String name;
	@JsonProperty("desc")
	private String description;
	@Column(name="START_TIME")
	private ZonedDateTime startTime;
	@Column(name="END_TIME")
	private ZonedDateTime endTime;
	@Column(name="ZONE_ID")
	private ZoneId zoneId;
	private Boolean started;
	
	public Event() {	
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID", nullable= false)
	private Organizer organizer;

	@OneToMany(mappedBy="event",fetch=FetchType.EAGER, cascade= CascadeType.ALL, orphanRemoval= true)
	private Set<Participant> participants;
	
	@RestResource(exported = false)
	@ManyToOne(fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	private Venue venue;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ZonedDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(ZonedDateTime startTime) {
		this.startTime = startTime;
	}
	public ZonedDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(ZonedDateTime endTime) {
		this.endTime = endTime;
	}
	public ZoneId getZoneId() {
		return zoneId;
	}
	public void setZoneId(ZoneId zoneId) {
		this.zoneId = zoneId;
	}
	public Boolean getStarted() {
		return started;
	}
	public void setStarted(Boolean started) {
		this.started = started;
	}
	public Set<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	
	public Long getResourceId() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Event) obj).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	


}

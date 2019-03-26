package com.ozdogan.eventManagement.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PARTICIPANT")
public class Participant extends AbstractEntity {
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	@Column(name = "CHECKED_IN")
	private Boolean checkedIn;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(referencedColumnName="ID", nullable=false, updatable=false)
	private Event event;
	
	public Participant() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
	public Long getResourceId() {
		return this.id;
	}
	
	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Participant) obj).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}

package com.ozdogan.eventManagement.entities;

import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
@MappedSuperclass
public class AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, updatable=false)
	protected Long id;
	
	@JsonIgnore
	@CreationTimestamp
	@Column(updatable=false)
	protected Instant created;
	
	public AbstractEntity() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getCreated() {
		return created;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}
	
	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((AbstractEntity) obj).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



}

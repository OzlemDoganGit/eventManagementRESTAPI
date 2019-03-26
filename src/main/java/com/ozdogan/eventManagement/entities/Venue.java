package com.ozdogan.eventManagement.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "VENUE")
public class Venue extends AbstractEntity {
	
	private String name;
	@Column(name="STREET_ADDRESS")
	private String streetAddress;
	@Column(name="STREET_ADDRESS2")
	private String streetAddress2;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE")
	private String state;
	private String country;
	@Column(name="POSTAL_CODE")
	private String postalCode;
	
	public Venue() {		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getStreetAddress2() {
		return streetAddress2;
	}
	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public Long getResourceId() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Venue) obj).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

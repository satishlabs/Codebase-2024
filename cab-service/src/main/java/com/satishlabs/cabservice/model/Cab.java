package com.satishlabs.cabservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cab {
	@Id
	private String id;
	private String location;
	private boolean isAvailable;
	
	public Cab() {}
	
	public Cab(String id, String location, boolean isAvailable) {
		this.id = id;
		this.location = location;
		this.isAvailable = isAvailable;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Cab [id=" + id + ", location=" + location + ", isAvailable=" + isAvailable + "]";
	}
	
	
}

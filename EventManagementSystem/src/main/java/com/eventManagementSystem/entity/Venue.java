package com.eventManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity

public class Venue {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private int capacity;
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Venue [id=" + id + ", name=" + name + ", location=" + location + ", capacity=" + capacity + ", event="
				+ event + "]";
	}

	public Venue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Long getId() {
		return id;
	}

	

    @OneToOne(mappedBy = "venue")
    private Event event;

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}
}
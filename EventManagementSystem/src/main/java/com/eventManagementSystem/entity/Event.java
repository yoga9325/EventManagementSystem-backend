package com.eventManagementSystem.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String eventName;
    private Date eventDate;
    private String description;
    @Override
	public String toString() {
		return "Event [id=" + id + ", eventName=" + eventName + ", eventDate=" + eventDate + ", description="
				+ description + ", organizer=" + organizer + ", venue=" + venue + "]";
	}

	

    public String getEventName() {
		return eventName;
	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public Event(Long id, String eventName, Date eventDate, String description, Organizer organizer, Venue venue) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.description = description;
		this.organizer = organizer;
		this.venue = venue;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Organizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public Long getId() {
		return id;
	}

	@ManyToOne
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}
}
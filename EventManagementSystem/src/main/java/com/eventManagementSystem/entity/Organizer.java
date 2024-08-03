package com.eventManagementSystem.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Organizer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String name;
    private String contactInfo;
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Long getId() {
		return id;
	}

	public Organizer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Organizer [id=" + id + ", name=" + name + ", contactInfo=" + contactInfo + ", events=" + events + "]";
	}

	
    public Organizer(Long id, String name, String contactInfo, List<Event> events) {
		super();
		this.id = id;
		this.name = name;
		this.contactInfo = contactInfo;
		this.events = events;
	}

	

    @OneToMany(mappedBy = "organizer")
    private List<Event> events;

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}
}
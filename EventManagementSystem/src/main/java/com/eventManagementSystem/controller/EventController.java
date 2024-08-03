package com.eventManagementSystem.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventManagementSystem.entity.Event;
import com.eventManagementSystem.entity.Organizer;
import com.eventManagementSystem.entity.Venue;
import com.eventManagementSystem.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.save(event);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Optional<Event> event = eventService.findById(id);
        return event.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
        Optional<Event> event = eventService.findById(id);
        if (event.isPresent()) {
            updatedEvent.setId(id);
            return ResponseEntity.ok(eventService.save(updatedEvent));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/venue/{venueId}")
    public List<Event> getEventsByVenue(@PathVariable Long venueId) {
        Venue venue = new Venue();
        venue.setId(venueId);
        return eventService.findByVenue(venue);
    }

    @GetMapping("/organizer/{organizerId}")
    public List<Event> getEventsByOrganizer(@PathVariable Long organizerId) {
        Organizer organizer = new Organizer();
        organizer.setId(organizerId);
        return eventService.findByOrganizer(organizer);
    }
}

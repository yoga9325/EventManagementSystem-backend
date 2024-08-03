package com.eventManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventManagementSystem.entity.Event;
import com.eventManagementSystem.entity.Organizer;
import com.eventManagementSystem.entity.Venue;
import com.eventManagementSystem.repository.EventRepository;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> findByVenue(Venue venue) {
        return eventRepository.findByVenue(venue);
    }

    public List<Event> findByOrganizer(Organizer organizer) {
        return eventRepository.findByOrganizer(organizer);
    }
}

package com.eventManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventManagementSystem.entity.Event;
import com.eventManagementSystem.entity.Organizer;
import com.eventManagementSystem.entity.Venue;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByVenue(Venue venue);
    List<Event> findByOrganizer(Organizer organizer);
}


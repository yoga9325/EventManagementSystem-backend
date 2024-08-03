package com.eventManagementSystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventManagementSystem.entity.Venue;
import com.eventManagementSystem.repository.VenueRepository;

@Service
public class VenueService {
    @Autowired
    private VenueRepository venueRepository;

    public Venue save(Venue venue) {
        return venueRepository.save(venue);
    }

    public Optional<Venue> findById(Long id) {
        return venueRepository.findById(id);
    }

    public void deleteById(Long id) {
        venueRepository.deleteById(id);
    }
}

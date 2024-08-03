package com.eventManagementSystem.controller;


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

import com.eventManagementSystem.entity.Venue;
import com.eventManagementSystem.service.VenueService;

@RestController
@RequestMapping("/venues")
public class VenueController {
    @Autowired
    private VenueService venueService;

    @PostMapping
    public Venue createVenue(@RequestBody Venue venue) {
        return venueService.save(venue);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venue> getVenueById(@PathVariable Long id) {
        Optional<Venue> venue = venueService.findById(id);
        return venue.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venue> updateVenue(@PathVariable Long id, @RequestBody Venue updatedVenue) {
        Optional<Venue> venue = venueService.findById(id);
        if (venue.isPresent()) {
            updatedVenue.setId(id);
            return ResponseEntity.ok(venueService.save(updatedVenue));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenue(@PathVariable Long id) {
        venueService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

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

import com.eventManagementSystem.entity.Organizer;
import com.eventManagementSystem.service.OrganizerService;

@RestController
@RequestMapping("/organizers")
public class OrganizerController {
    @Autowired
    private OrganizerService organizerService;

    @PostMapping
    public Organizer createOrganizer(@RequestBody Organizer organizer) {
        return organizerService.save(organizer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organizer> getOrganizerById(@PathVariable Long id) {
        Optional<Organizer> organizer = organizerService.findById(id);
        return organizer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Organizer> updateOrganizer(@PathVariable Long id, @RequestBody Organizer updatedOrganizer) {
        Optional<Organizer> organizer = organizerService.findById(id);
        if (organizer.isPresent()) {
            updatedOrganizer.setId(id);
            return ResponseEntity.ok(organizerService.save(updatedOrganizer));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable Long id) {
        organizerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

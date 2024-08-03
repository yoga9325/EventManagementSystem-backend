package com.eventManagementSystem.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventManagementSystem.entity.Organizer;
import com.eventManagementSystem.repository.OrganizerRepository;

@Service
public class OrganizerService {
    @Autowired
    private OrganizerRepository organizerRepository;

    public Organizer save(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public Optional<Organizer> findById(Long id) {
        return organizerRepository.findById(id);
    }

    public void deleteById(Long id) {
        organizerRepository.deleteById(id);
    }
}

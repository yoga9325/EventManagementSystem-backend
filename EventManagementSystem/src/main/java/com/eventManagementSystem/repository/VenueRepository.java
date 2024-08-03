package com.eventManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventManagementSystem.entity.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long> { }


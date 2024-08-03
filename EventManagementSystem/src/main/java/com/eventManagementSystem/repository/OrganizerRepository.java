package com.eventManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventManagementSystem.entity.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> 
{ }
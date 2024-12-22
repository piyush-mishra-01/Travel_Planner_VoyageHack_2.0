package com.voyage.ItenaryManagementService.repository;

import com.voyage.ItenaryManagementService.model.CustomItinerary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomItineraryRepository extends JpaRepository<CustomItinerary, Long> {
}

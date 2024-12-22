package com.voyage.ItenaryManagementService.repository;

import com.voyage.ItenaryManagementService.model.PredefinedIteniariesActivity;
import com.voyage.ItenaryManagementService.model.PredefinedIteniary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PredefinedItineraryActivityRepository extends JpaRepository<PredefinedIteniariesActivity, Long> {
    Optional<PredefinedIteniariesActivity> findByNameAndPredefinedIteniary(String name, PredefinedIteniary predefinedItinerary);
}

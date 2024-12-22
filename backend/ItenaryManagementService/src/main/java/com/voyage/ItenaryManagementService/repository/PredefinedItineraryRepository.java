package com.voyage.ItenaryManagementService.repository;

import com.voyage.ItenaryManagementService.model.Location;
import com.voyage.ItenaryManagementService.model.PredefinedIteniary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PredefinedItineraryRepository extends JpaRepository<PredefinedIteniary, Long> {
    Optional<PredefinedIteniary> findByTitleAndLocation(String title, Location location);

    List<PredefinedIteniary> findByLocationId(Long locationId);
}

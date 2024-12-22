package com.voyage.ItenaryManagementService.repository;

import com.voyage.ItenaryManagementService.model.AllItineraries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AllItineraryRepository extends JpaRepository<AllItineraries, Long> {
    List<AllItineraries> findByUserId(Long userId);
}

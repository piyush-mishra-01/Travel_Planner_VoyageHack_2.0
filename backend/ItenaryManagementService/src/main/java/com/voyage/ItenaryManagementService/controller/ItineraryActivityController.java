package com.voyage.ItenaryManagementService.controller;

import com.voyage.ItenaryManagementService.model.ItineraryActivity;
import com.voyage.ItenaryManagementService.repository.ItineraryActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itinerary-activities")
public class ItineraryActivityController {

    @Autowired
    private ItineraryActivityRepository itineraryActivitiesRepository;

    // Endpoint to add multiple activities
    @PostMapping("/add")
    public ResponseEntity<String> addItineraryActivities(@RequestBody List<ItineraryActivity> activities) {
        itineraryActivitiesRepository.saveAll(activities);
        return ResponseEntity.ok("Itinerary activities added successfully!");
    }

    // Optional: Endpoint to fetch all activities
    @GetMapping("/all")
    public ResponseEntity<List<ItineraryActivity>> getAllActivities() {
        return ResponseEntity.ok(itineraryActivitiesRepository.findAll());
    }
}

package com.voyage.ItenaryManagementService.controller;

import com.voyage.ItenaryManagementService.model.AllItineraries;
import com.voyage.ItenaryManagementService.model.AllItineraryActivities;
import com.voyage.ItenaryManagementService.service.AllItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-itineraries")
public class AllItineraryController {

    @Autowired
    private AllItineraryService allItineraryService;

    // Add a new itinerary to AllItineraries
    @PostMapping
    public ResponseEntity<AllItineraries> addItinerary(@RequestBody AllItineraries itinerary) {
        AllItineraries savedItinerary = allItineraryService.addItinerary(itinerary);
        return ResponseEntity.ok(savedItinerary);
    }

    // Add activities to an itinerary in AllItineraryActivities
    @PostMapping("/{itineraryId}/activities")
    public ResponseEntity<List<AllItineraryActivities>> addActivities(
            @PathVariable Long itineraryId,
            @RequestBody List<AllItineraryActivities> activities) {
        List<AllItineraryActivities> savedActivities = allItineraryService.addActivities(itineraryId, activities);
        return ResponseEntity.ok(savedActivities);
    }

    // Get all itineraries for a user
    @GetMapping
    public ResponseEntity<List<AllItineraries>> getUserItineraries(@RequestParam Long userId) {
        List<AllItineraries> itineraries = allItineraryService.getItinerariesByUserId(userId);
        return ResponseEntity.ok(itineraries);
    }

    // Update an itinerary
    @PutMapping("/{id}")
    public ResponseEntity<AllItineraries> updateItinerary(@PathVariable Long id, @RequestBody AllItineraries itinerary) {
        AllItineraries updatedItinerary = allItineraryService.updateItinerary(id, itinerary);
        return ResponseEntity.ok(updatedItinerary);
    }

    // Delete an itinerary
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItinerary(@PathVariable Long id) {
        allItineraryService.deleteItinerary(id);
        return ResponseEntity.noContent().build();
    }
}

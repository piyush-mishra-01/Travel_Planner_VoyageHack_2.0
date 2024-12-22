package com.voyage.ItenaryManagementService.controller;

import com.voyage.ItenaryManagementService.model.CustomItinerary;
import com.voyage.ItenaryManagementService.service.CustomItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/custom-itineraries")
public class CustomItineraryController {

    @Autowired
    private CustomItineraryService customItineraryService;

    // Get all custom itineraries
    @GetMapping
    public ResponseEntity<List<CustomItinerary>> getAllCustomItineraries() {
        List<CustomItinerary> itineraries = customItineraryService.getAllCustomItineraries();
        return ResponseEntity.ok(itineraries);
    }

    // Get custom itineraries by user ID
    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<CustomItinerary>> getCustomItinerariesByUserId(@PathVariable Long userId) {
        List<CustomItinerary> itineraries = customItineraryService.getCustomItinerariesByUserId(userId);
        return ResponseEntity.ok(itineraries);
    }

    // Get a specific custom itinerary by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomItinerary> getCustomItineraryById(@PathVariable Long id) {
        CustomItinerary itinerary = customItineraryService.getCustomItineraryById(id);
        return ResponseEntity.ok(itinerary);
    }

    // Create a new custom itinerary
    @PostMapping
    public ResponseEntity<CustomItinerary> createCustomItinerary(@RequestBody CustomItinerary customItinerary) {
        CustomItinerary createdItinerary = customItineraryService.createCustomItinerary(customItinerary);
        return ResponseEntity.ok(createdItinerary);
    }

    // Update an existing custom itinerary
    @PutMapping("/{id}")
    public ResponseEntity<CustomItinerary> updateCustomItinerary(
            @PathVariable Long id,
            @RequestBody CustomItinerary customItinerary) {
        CustomItinerary updatedItinerary = customItineraryService.updateCustomItinerary(id, customItinerary);
        return ResponseEntity.ok(updatedItinerary);
    }

    // Delete a custom itinerary
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomItinerary(@PathVariable Long id) {
        customItineraryService.deleteCustomItinerary(id);
        return ResponseEntity.noContent().build();
    }
}

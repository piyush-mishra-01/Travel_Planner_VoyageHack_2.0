package com.voyage.ItenaryManagementService.controller;

import com.voyage.ItenaryManagementService.model.PredefinedIteniary;
import com.voyage.ItenaryManagementService.repository.PredefinedItineraryRepository;
import com.voyage.ItenaryManagementService.service.PredefinedItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/predefined-itineraries/activities")
public class PredefinedItineraryController {

    @Autowired
    PredefinedItineraryService predefinedItineraryService;

    @GetMapping
    public ResponseEntity<List<PredefinedIteniary>> getAllActivities() {
        List<PredefinedIteniary> activities = predefinedItineraryService.getAllActivities();
        return ResponseEntity.ok(activities);
    }

    @GetMapping("/by-location/{locationId}")
    public ResponseEntity<List<PredefinedIteniary>> getItinerariesByLocationId(@PathVariable Long locationId) {
        List<PredefinedIteniary> itineraries = predefinedItineraryService.getItinerariesByLocationId(locationId);
        return ResponseEntity.ok(itineraries);
    }

}

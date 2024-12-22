package com.voyage.ItenaryManagementService.service;

import com.voyage.ItenaryManagementService.model.PredefinedIteniary;

import java.util.List;

public interface PredefinedItineraryService {
    PredefinedIteniary createItinerary(PredefinedIteniary customItinerary);

    List<PredefinedIteniary> getAllItineraries();

    PredefinedIteniary getItineraryById(Long id);

    PredefinedIteniary updateItinerary(Long id, PredefinedIteniary customItinerary);

    void deleteItinerary(Long id);

    List<PredefinedIteniary> getAllActivities();

    List<PredefinedIteniary> getItinerariesByLocationId(Long locationId);
}

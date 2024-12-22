package com.voyage.ItenaryManagementService.service;

import com.voyage.ItenaryManagementService.model.AllItineraries;
import com.voyage.ItenaryManagementService.model.AllItineraryActivities;

import java.util.List;

public interface AllItineraryService {
    AllItineraries addItinerary(AllItineraries itinerary);

    List<AllItineraryActivities> addActivities(Long itineraryId, List<AllItineraryActivities> activities);

    List<AllItineraries> getItinerariesByUserId(Long userId);

    AllItineraries updateItinerary(Long id, AllItineraries itinerary);

    void deleteItinerary(Long id);
}

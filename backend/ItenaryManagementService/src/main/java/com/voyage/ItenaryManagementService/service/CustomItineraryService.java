package com.voyage.ItenaryManagementService.service;

import com.voyage.ItenaryManagementService.model.CustomItinerary;

import java.util.List;

public interface CustomItineraryService {
    List<CustomItinerary> getAllCustomItineraries();

    List<CustomItinerary> getCustomItinerariesByUserId(Long userId);

    CustomItinerary getCustomItineraryById(Long id);

    CustomItinerary createCustomItinerary(CustomItinerary customItinerary);

    CustomItinerary updateCustomItinerary(Long id, CustomItinerary customItinerary);

    void deleteCustomItinerary(Long id);
}

package com.voyage.ItenaryManagementService.service.serviceImpl;

import com.voyage.ItenaryManagementService.model.CustomItinerary;
import com.voyage.ItenaryManagementService.service.CustomItineraryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomItineraryServiceImpl implements CustomItineraryService {
    @Override
    public List<CustomItinerary> getAllCustomItineraries() {
        return List.of();
    }

    @Override
    public List<CustomItinerary> getCustomItinerariesByUserId(Long userId) {
        return List.of();
    }

    @Override
    public CustomItinerary getCustomItineraryById(Long id) {
        return null;
    }

    @Override
    public CustomItinerary createCustomItinerary(CustomItinerary customItinerary) {
        return null;
    }

    @Override
    public CustomItinerary updateCustomItinerary(Long id, CustomItinerary customItinerary) {
        return null;
    }

    @Override
    public void deleteCustomItinerary(Long id) {

    }
}

package com.voyage.ItenaryManagementService.service.serviceImpl;

import com.voyage.ItenaryManagementService.model.PredefinedIteniary;
import com.voyage.ItenaryManagementService.repository.PredefinedItineraryRepository;
import com.voyage.ItenaryManagementService.service.PredefinedItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PredefinedItineraryServiceImpl implements PredefinedItineraryService {

    @Autowired
    private PredefinedItineraryRepository predefinedItineraryRepository;

    @Override
    public PredefinedIteniary createItinerary(PredefinedIteniary customItinerary) {
        return predefinedItineraryRepository.save(customItinerary);

    }

    @Override
    public List<PredefinedIteniary> getAllItineraries() {
        return predefinedItineraryRepository.findAll();
    }

    @Override
    public PredefinedIteniary getItineraryById(Long id) {
        return predefinedItineraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Itinerary not found"));
    }

    @Override
    public PredefinedIteniary updateItinerary(Long id, PredefinedIteniary updatedPredefinedIteniary) {
        PredefinedIteniary itinerary = getItineraryById(id);
//        itinerary.setTripName(updatedPredefinedIteniary.getTripName());
//        itinerary.setTripStartDate(updatedPredefinedIteniary.getTripStartDate());
//        itinerary.setTripEndDate(updatedPredefinedIteniary.getTripEndDate());
//        itinerary.setDescription(updatedPredefinedIteniary.getDescription());
        return predefinedItineraryRepository.save(updatedPredefinedIteniary);
    }

    @Override
    public void deleteItinerary(Long id) {
        predefinedItineraryRepository.deleteById(id);

    }

    @Override
    public List<PredefinedIteniary> getAllActivities() {
        return predefinedItineraryRepository.findAll();
    }

    @Override
    public List<PredefinedIteniary> getItinerariesByLocationId(Long locationId) {
        return predefinedItineraryRepository.findByLocationId(locationId);
    }
}

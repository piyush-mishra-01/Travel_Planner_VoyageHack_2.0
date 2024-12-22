package com.voyage.ItenaryManagementService.service.serviceImpl;

import com.voyage.ItenaryManagementService.model.AllItineraries;
import com.voyage.ItenaryManagementService.model.AllItineraryActivities;
import com.voyage.ItenaryManagementService.repository.AllItineraryActivitiesRepository;
import com.voyage.ItenaryManagementService.repository.AllItineraryRepository;
import com.voyage.ItenaryManagementService.service.AllItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllItineraryServiceImpl implements AllItineraryService {

    @Autowired
    private AllItineraryRepository allItinerariesRepository;

    @Autowired
    private AllItineraryActivitiesRepository allItineraryActivitiesRepository;

    @Override
    public AllItineraries addItinerary(AllItineraries itinerary) {
        return allItinerariesRepository.save(itinerary);
    }

    @Override
    public List<AllItineraryActivities> addActivities(Long itineraryId, List<AllItineraryActivities> activities) {
        activities.forEach(activity -> activity.setItinerary(allItinerariesRepository.findById(itineraryId).orElseThrow()));
        return allItineraryActivitiesRepository.saveAll(activities);
    }

    @Override
    public List<AllItineraries> getItinerariesByUserId(Long userId) {
        return allItinerariesRepository.findByUserId(userId);
    }

    @Override
    public AllItineraries updateItinerary(Long id, AllItineraries itinerary) {
        AllItineraries existingItinerary = allItinerariesRepository.findById(id).orElseThrow();
        existingItinerary.setTitle(itinerary.getTitle());
        existingItinerary.setDescription(itinerary.getDescription());
        existingItinerary.setStartDate(itinerary.getStartDate());
        existingItinerary.setEndDate(itinerary.getEndDate());
        return allItinerariesRepository.save(existingItinerary);
    }

    @Override
    public void deleteItinerary(Long id) {
        allItinerariesRepository.deleteById(id);
    }


}

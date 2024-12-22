package com.voyage.ItenaryManagementService.utils;

import com.voyage.ItenaryManagementService.model.*;
import com.voyage.ItenaryManagementService.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    PredefinedItineraryActivityRepository predefinedItineraryActivityRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    PredefinedItineraryRepository predefinedItineraryRepository;

    @Override
    public void run(String... args) throws Exception {
        // Add sample locations
        createLocationIfNotExists("Paris",
                "The capital city of France, known for its art, fashion, and landmarks.",
                "France", "Île-de-France");

        createLocationIfNotExists("New York",
                "A major city in the United States, famous for its skyscrapers and cultural landmarks.",
                "United States", "New York");

        createLocationIfNotExists("Tokyo",
                "The capital city of Japan, known for its modern architecture and traditional temples.",
                "Japan", "Kanto");

        createLocationIfNotExists("Rome",
                "The capital of Italy, famous for its ancient history, art, and architecture.",
                "Italy", "Lazio");

        createLocationIfNotExists("Sydney",
                "A major city in Australia known for its beautiful harbor, beaches, and iconic Opera House.",
                "Australia", "New South Wales");

        // Add sample itineraries and activities for each location
        for (int i = 1; i <= 5; i++) {
            Location location = locationRepository.findById((long) i).orElse(null);
            if (location != null) {
                for (int j = 1; j <= 4; j++) {
                    PredefinedIteniary predefinedItinerary = createItineraryIfNotExists(
                            location,
                            LocalDate.of(2025, 6, 1).plusDays((j - 1) * 5),
                            LocalDate.of(2025, 6, 7).plusDays((j - 1) * 5),
                            location.getLocationName() + " Trip " + j,
                            location.getLocationName() + " trip, exploring main attractions."
                    );

                    // Add activities for each itinerary
                    for (int k = 1; k <= 3; k++) {
                        createActivityIfNotExists(
                                predefinedItinerary,
                                location.getLocationName() + " Activity " + k,
                                location.getLocationName() + " activity description " + k,
                                LocalTime.of(9 + k, 0),
                                LocalTime.of(11 + k, 0)
                        );
                    }
                }
            }
        }
    }

    private void createLocationIfNotExists(String name, String description, String country, String region) {
        Optional<Location> existingLocation = locationRepository.findByLocationName(name);
        if (existingLocation.isEmpty()) {
            Location location = new Location();
            location.setLocationName(name);
            location.setDescription(description);
            location.setCountry(country);
            location.setRegion(region);
            locationRepository.save(location);
        }
    }

    private PredefinedIteniary createItineraryIfNotExists(
            Location location, LocalDate startDate, LocalDate endDate, String title, String description) {
        Optional<PredefinedIteniary> existingItinerary = predefinedItineraryRepository.findByTitleAndLocation(title, location);
        if (existingItinerary.isEmpty()) {
            PredefinedIteniary predefinedItinerary = new PredefinedIteniary();
            predefinedItinerary.setLocation(location);
            predefinedItinerary.setStartDate(startDate);
            predefinedItinerary.setEndDate(endDate);
            predefinedItinerary.setTitle(title);
            predefinedItinerary.setDescription(description);
            return predefinedItineraryRepository.save(predefinedItinerary);
        }
        return existingItinerary.get();
    }

    private void createActivityIfNotExists(
            PredefinedIteniary predefinedItinerary, String name, String description, LocalTime startTime, LocalTime endTime) {
        Optional<PredefinedIteniariesActivity> existingActivity = predefinedItineraryActivityRepository
                .findByNameAndPredefinedIteniary(name, predefinedItinerary);
        if (existingActivity.isEmpty()) {
            PredefinedIteniariesActivity activity = new PredefinedIteniariesActivity();
            activity.setPredefinedIteniary(predefinedItinerary);
            activity.setName(name);
            activity.setDescription(description);
            activity.setStartTime(startTime);
            activity.setEndTime(endTime);
            predefinedItineraryActivityRepository.save(activity);
        }
    }
}

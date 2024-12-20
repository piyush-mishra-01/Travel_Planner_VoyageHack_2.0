package com.voyage.ItenaryManagementService.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "itinerary_activities")
public class ItineraryActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activityId;

    @ManyToOne
    @JoinColumn(name = "itinerary_id", referencedColumnName = "itinerary_id", nullable = false)
    private Itinerary itinerary; // Reference to the Itinerary entity

    private String activityName;

    private String location;

    private String startTime;

    private String endTime;

    private String details;
}


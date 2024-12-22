package com.voyage.ItenaryManagementService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomItineraryActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customitinerary_id", nullable = false)
    private CustomItinerary customItinerary;

    private String name;
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;

}

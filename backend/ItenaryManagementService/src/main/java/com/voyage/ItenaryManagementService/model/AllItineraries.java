package com.voyage.ItenaryManagementService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AllItineraries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private LocalDate startDate;
    private LocalDate endDate;

    @Column(nullable = false)
    private Long userId; // User association

    @Column(nullable = false)
    private String locationName; // For convenience

    private String sourceType; // "predefined" or "custom"
}

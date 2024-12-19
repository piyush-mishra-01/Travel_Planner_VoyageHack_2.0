package com.voyage.userManagementService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PastTrips {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private UserProfile userProfile;

    private String destination;

    private String startDate;

    private String endDate;

    @ElementCollection
    @CollectionTable(name = "trip_activities", joinColumns = @JoinColumn(name = "trip_id"))
    @Column(name = "activity")
    private List<String> activities; // List of activities

    private String travelMode;

    private Double totalExpense;

    @ElementCollection
    @CollectionTable(name = "trip_companions", joinColumns = @JoinColumn(name = "trip_id"))
    @Column(name = "companion")
    private List<String> companions; // List of travel companions

    private String feedback;

    private String specialNotes;
}


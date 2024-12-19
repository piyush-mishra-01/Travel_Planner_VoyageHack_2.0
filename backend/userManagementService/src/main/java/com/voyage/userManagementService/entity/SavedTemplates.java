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
public class SavedTemplates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long templateId;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private UserProfile userProfile;

    private String templateName;

    private String destination;

    @ElementCollection
    @CollectionTable(name = "template_activities", joinColumns = @JoinColumn(name = "template_id"))
    @Column(name = "activity")
    private List<String> plannedActivities;

    private String idealStartDate;

    private String idealEndDate;

    private String preferredTravelMode;

    private Double estimatedBudget;

    private Integer groupSize;

    private String specialPreferences;

    private Boolean isDraft;
}

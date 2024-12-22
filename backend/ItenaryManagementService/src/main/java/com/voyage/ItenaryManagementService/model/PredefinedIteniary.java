package com.voyage.ItenaryManagementService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class PredefinedIteniary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    private LocalDate startDate;
    private LocalDate endDate;
    private String title;
    private String description;

    @OneToMany(mappedBy = "predefinedIteniary", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<PredefinedIteniariesActivity> activities;
}

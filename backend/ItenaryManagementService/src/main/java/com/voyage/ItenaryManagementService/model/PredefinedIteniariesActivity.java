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
public class PredefinedIteniariesActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "predefineditinerary_id", nullable = false)
    private PredefinedIteniary predefinedIteniary;
    private String name;
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;

}

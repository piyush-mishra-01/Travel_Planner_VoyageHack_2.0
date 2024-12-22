package com.voyage.budgetManagementService.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long budgetId;

    @OneToOne
    @JoinColumn(name = "itinerary_id", nullable = false)
    private Itinerary itinerary;

    private double totalBudget;
    private double allocatedBudget;
    private double remainingBudget;

    @OneToMany(mappedBy = "budget", cascade = CascadeType.ALL)
    private List<Expense> expenses;

    // Getters and Setters
}
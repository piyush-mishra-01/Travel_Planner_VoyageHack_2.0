package com.voyage.budgetManagementService.models;

import jakarta.persistence.*;

@Entity
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long currencyId;

    private String currencyCode;
    private double exchangeRate;
    private double inflationRate;

    // Getters and Setters
}
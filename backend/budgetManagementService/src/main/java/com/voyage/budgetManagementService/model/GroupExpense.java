package com.voyage.budgetManagementService.models;

import jakarta.persistence.*;

@Entity
public class GroupExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupExpenseId;

    @ManyToOne
    @JoinColumn(name = "budget_id", nullable = false)
    private Budget budget;

    private Long userId;
    private double contribution;
    private double expenseShare;

    // Getters and Setters
}
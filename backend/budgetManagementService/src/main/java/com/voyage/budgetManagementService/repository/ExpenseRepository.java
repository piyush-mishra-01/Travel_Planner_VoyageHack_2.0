package com.travelplanner.budget.repositories;

import com.travelplanner.budget.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
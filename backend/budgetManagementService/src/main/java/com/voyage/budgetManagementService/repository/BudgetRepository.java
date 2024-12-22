package com.travelplanner.budget.repositories;

import com.travelplanner.budget.models.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
}
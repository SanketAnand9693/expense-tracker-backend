package com.sannix.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sannix.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}

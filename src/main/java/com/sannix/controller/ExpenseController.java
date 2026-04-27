package com.sannix.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sannix.entity.Expense;
import com.sannix.repo.ExpenseRepository;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "http://localhost:4200") // Angular app URL
public class ExpenseController {

    private final ExpenseRepository expenseRepo;

    public ExpenseController(ExpenseRepository expenseRepo) {
        this.expenseRepo = expenseRepo;
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseRepo.findAll();
    }

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        return expenseRepo.save(expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseRepo.deleteById(id);
    }
}


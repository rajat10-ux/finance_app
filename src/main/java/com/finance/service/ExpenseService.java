package com.finance.service;

import com.finance.DTO.ExpenseDTO;
import com.finance.Entity.Expense;
import com.finance.Repository.ExpenseRepository;
import com.finance.Request.ExpenseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    public List<ExpenseDTO>getAllExpenses(){
        return expenseRepository.findAll()
                .stream().map(a -> new ExpenseDTO(
                        a.getAmount(),
                        a.getCategory(),
                        a.getDescription(),
                        a.getDate()
                )).toList();
    }

    public ExpenseDTO createRequest(ExpenseRequest expenseRequest){
        Expense expense = new Expense();
        expense.setAmount(expenseRequest.getAmount());
        expense.setCategory(expenseRequest.getCategory());
        expense.setDescription(expenseRequest.getDescription());
        expense.setDate(expenseRequest.getDate());

        Expense savedExpense = expenseRepository.save(expense);
        return new ExpenseDTO(
                savedExpense.getAmount(),
                savedExpense.getCategory(),
                savedExpense.getDescription(),
                savedExpense.getDate()
        );
    }

    public List<ExpenseDTO> getExpenseByCategory(String category) {
        return expenseRepository.findByCategoryIgnoreCase(category)
                .stream()
                .map(e -> new ExpenseDTO(
                        e.getAmount(),
                        e.getCategory(),
                        e.getDescription(),
                        e.getDate()
                ))
                .toList();
    }

    public List<ExpenseDTO> getExpensesByDate(String category, String sort) {
        List<Expense> expenses;
        if (category != null && !category.isBlank()) {
            expenses = expenseRepository.findByCategoryIgnoreCase(category);
        } else {
            expenses = expenseRepository.findAll();
        }
        if ("date_desc".equalsIgnoreCase(sort)) {
            expenses = expenses.stream()
                    .sorted((a, b) -> {
                        if (a.getDate() == null) return 1;
                        if (b.getDate() == null) return -1;
                        return b.getDate().compareTo(a.getDate());
                    })
                    .toList();
        } else if ("date_asc".equalsIgnoreCase(sort)) {
            expenses = expenses.stream()
                    .sorted((a, b) -> {
                        if (a.getDate() == null) return 1;
                        if (b.getDate() == null) return -1;
                        return a.getDate().compareTo(b.getDate());
                    })
                    .toList();
        }
        return expenses.stream()
                .map(e -> new ExpenseDTO(
                        e.getAmount(),
                        e.getCategory(),
                        e.getDescription(),
                        e.getDate()
                ))
                .toList();
    }
}

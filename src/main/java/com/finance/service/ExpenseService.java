package com.finance.service;

import com.finance.DTO.ExpenseDTO;
import com.finance.Entity.Expense;
import com.finance.Repository.ExpenseRepository;
import com.finance.Request.ExpenseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}

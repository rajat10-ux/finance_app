package com.finance.controllers;

import com.finance.DTO.ExpenseDTO;
import com.finance.Request.ExpenseRequest;
import com.finance.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;
    @GetMapping("/get_Expense")
    public ResponseEntity<?> getAllExpensesList() {
        try {
            List<ExpenseDTO> allExpenses = expenseService.getAllExpenses();
            return ResponseEntity.ok(allExpenses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
    @PostMapping("/create_Expense")
    public ResponseEntity<?>createExpense(@RequestBody ExpenseRequest expenseRequest){
        try {
            ExpenseDTO request = expenseService.createRequest(expenseRequest);
            return new ResponseEntity<>(request,HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}

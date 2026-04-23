package com.finance.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
public class ExpenseDTO {
    private Long amount;
    private String category;
    private String description;
    private LocalDate date;

    public ExpenseDTO(Long amount, String category, String description, LocalDate date) {
    this.amount=amount;
    this.date=date;
    this.category=category;
    this.description=description;
    }
}

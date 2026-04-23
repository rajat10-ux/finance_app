package com.finance.Repository;

import com.finance.DTO.ExpenseDTO;
import com.finance.Entity.Expense;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    List<ExpenseDTO> findByCategory(String category);

    List<Expense> findByCategoryIgnoreCase(String category);
}

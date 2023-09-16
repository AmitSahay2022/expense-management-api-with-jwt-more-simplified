package com.sahayji.exp.management.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahayji.exp.management.entity.Expense;
import com.sahayji.exp.management.service.ExpenseService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/expenses")
@AllArgsConstructor
public class ExpenseController {

	private ExpenseService expenseService;
	@PostMapping
	public ResponseEntity<Expense> saveExpense(@Valid @RequestBody Expense expense){
		return new ResponseEntity<Expense>(expenseService.save(expense),HttpStatus.CREATED);
	}
	@PutMapping("{expenseid}")
	public ResponseEntity<Expense> updateExpense(@Valid @RequestBody Expense expense,			                                    
			                                     @PathVariable long expenseid){
		
		return new ResponseEntity<Expense>(expenseService.update(expenseid, expense),HttpStatus.OK);
	}
	@DeleteMapping("{expenseid}")
	public ResponseEntity<String> deleteExpense(@PathVariable long expenseid){
		return new ResponseEntity<String>(expenseService.delete(expenseid),HttpStatus.OK);
	}
	@GetMapping("{expenseid}")
	public ResponseEntity<Expense> getExpenseById(@PathVariable long expenseid){
		return new ResponseEntity<Expense>(expenseService.getById(expenseid),HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<Page<Expense>> getAllExpenses(Pageable pageable){
		return new ResponseEntity<Page<Expense>>(expenseService.getAllExpense(pageable),HttpStatus.OK);
	}
}

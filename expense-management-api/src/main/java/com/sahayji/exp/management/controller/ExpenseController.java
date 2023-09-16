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
	@PostMapping("{userid}")
	public ResponseEntity<Expense> saveExpense(@Valid @RequestBody Expense expense,@PathVariable long userid){
		return new ResponseEntity<Expense>(expenseService.save(expense, userid),HttpStatus.CREATED);
	}
	@PutMapping("{userid}/{expenseid}")
	public ResponseEntity<Expense> updateExpense(@Valid @RequestBody Expense expense,
			                                     @PathVariable long userid,
			                                     @PathVariable long expenseid){
		
		return new ResponseEntity<Expense>(expenseService.update(userid, expenseid, expense),HttpStatus.OK);
	}
	@DeleteMapping("{userid}/{expenseid}")
	public ResponseEntity<String> deleteExpense(@PathVariable long userid,@PathVariable long expenseid){
		return new ResponseEntity<String>(expenseService.delete(userid, expenseid),HttpStatus.OK);
	}
	@GetMapping("{userid}/{expenseid}")
	public ResponseEntity<Expense> getExpenseById(@PathVariable long userid,@PathVariable long expenseid){
		return new ResponseEntity<Expense>(expenseService.getById(userid, expenseid),HttpStatus.OK);
	}
	@GetMapping("{userid}")
	public ResponseEntity<Page<Expense>> getAllExpenses(@PathVariable long userid, Pageable pageable){
		return new ResponseEntity<Page<Expense>>(expenseService.getAllExpense(userid, pageable),HttpStatus.OK);
	}
}

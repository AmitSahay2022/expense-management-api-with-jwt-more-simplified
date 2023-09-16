package com.sahayji.exp.management.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sahayji.exp.management.entity.Expense;
import com.sahayji.exp.management.entity.User;

public interface ExpenseService {
     
	public Expense save(Expense expense, long userid);
	
	public Expense getById(long userid,long expenseid);
	
	public Expense update(long userid,long expenseid,Expense expense);
	
	public String delete(long userid,long expenseid);
	
	public Page<Expense> getAllExpense(long userid,Pageable pageable);
}

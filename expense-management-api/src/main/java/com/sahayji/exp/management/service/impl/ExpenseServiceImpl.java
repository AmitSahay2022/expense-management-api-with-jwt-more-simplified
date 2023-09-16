package com.sahayji.exp.management.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sahayji.exp.management.entity.Expense;
import com.sahayji.exp.management.entity.User;
import com.sahayji.exp.management.exception.ResourceNotFoundException;
import com.sahayji.exp.management.repository.ExpenseRepository;
import com.sahayji.exp.management.service.ExpenseService;
import com.sahayji.exp.management.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
	private ExpenseRepository expenseRepository;
	private UserService userService;

	@Override
	public Expense save(Expense expense,long userid) {
		// TODO Auto-generated method stub
		User user = userService.getUser(userid);
		expense.setUser(user);
		return expenseRepository.save(expense);
	}

	@Override
	public Expense getById(long userid, long expenseid) {
		// TODO Auto-generated method stub
		User user = userService.getUser(userid);
		
		return expenseRepository.findByUserIdAndId(userid, expenseid)
				.orElseThrow(()->new ResourceNotFoundException("Expense not found"));
	}

	@Override
	public Expense update(long userid, long expenseid,Expense exp) {
		// TODO Auto-generated method stub
		Expense expense = getById(userid, expenseid);
		expense.setAmount(exp.getAmount());
		expense.setCategory(exp.getCategory());
		expense.setDate(exp.getDate());
		expense.setDescription(exp.getDescription());
		expense.setName(exp.getName());
		return expenseRepository.save(expense);
	}

	@Override
	public String delete(long userid, long expenseid) {
		// TODO Auto-generated method stub
		Expense expense = getById(userid, expenseid);
		expenseRepository.delete(expense);
		return "Expense Record Deleted Successfully";
	}

	@Override
	public Page<Expense> getAllExpense(long userid, Pageable pageable) {
		// TODO Auto-generated method stub
		return expenseRepository.findByUserId(userid, pageable);
	}

}

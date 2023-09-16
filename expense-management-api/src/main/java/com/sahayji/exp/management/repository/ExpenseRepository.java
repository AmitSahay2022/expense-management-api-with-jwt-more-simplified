package com.sahayji.exp.management.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sahayji.exp.management.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{

	Optional<Expense> findByUserIdAndId(long userid,long expenseid);
	
	Page<Expense> findByUserId(long userid,Pageable pageable);
}

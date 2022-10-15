package com.project.loanApplication.controller;

import java.util.List;

import com.project.loanApplication.dto.NewLoanFormDetails;
import com.project.loanApplication.entity.LoanDetails;
import com.project.loanApplication.entity.PaymentSchedule;
import com.project.loanApplication.service.NewLoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewLoanController 
{
	@Autowired
	NewLoanService service;
	
	@CrossOrigin
	@PostMapping("newloan")
	public String newLoan(@RequestBody NewLoanFormDetails details)
	{
		return service.newLoan(details) ;
	}
	
	@CrossOrigin
	@GetMapping("displayloan")
	public List<LoanDetails> DisplayLoan()
	{
		return service.DisplayLoan();
	}
	
	@CrossOrigin
	@GetMapping("displayschedule")
	public List<PaymentSchedule> DisplaySchedule()
	{
		return service.DisplaySchedule();
	}
	@CrossOrigin
	@RequestMapping("")
	public void UpdatePaymentSchedule(@RequestBody String status)
	{
		
	}
}

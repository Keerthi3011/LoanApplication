package com.project.loanApplication.service;

import java.time.LocalDate;
import java.util.List;

import com.project.loanApplication.dto.NewLoanFormDetails;
import com.project.loanApplication.entity.LoanDetails;
import com.project.loanApplication.entity.PaymentSchedule;
import com.project.loanApplication.entityEnum.PaymentStatus;
import com.project.loanApplication.interfaces.NewLoanInterface;
import com.project.loanApplication.interfaces.PaymentScheduleInterface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class NewLoanService 
{
	Logger log =LoggerFactory.getLogger(NewLoanService.class);
	
	PaymentSchedule payment = new PaymentSchedule();
	@Autowired
	NewLoanInterface newLoan;
	@Autowired
	PaymentScheduleInterface schedule;
	
	int paymentSchedule ,count=1;
	
	public String newLoan(NewLoanFormDetails details) 
	{
		LoanDetails loan = new LoanDetails();
	// creating the new loan for a customer
		loan.setLoanAmount(details.getLoanAmount());
		loan.setTradeDate(LocalDate.now());
		loan.setLoanStartDate(loan.getTradeDate().plusDays( details.getLoanStartDate()));
		loan.setMaturityDate(loan.getLoanStartDate().plusMonths(details.getNoOfMonth()));
		loan.setPaymentFrequency(details.getPaymentFrequency());
		loan.setInterestRate(details.getInterestRate());
		
	//	generatePaymentSchedule(details);
		
		double principal = details.getLoanAmount(), interest = 0;
		PaymentSchedule data1 = null;
		LocalDate paymentDate = loan.getLoanStartDate();
		paymentSchedule = (details.getNoOfMonth()/details.getPaymentFrequency());
		payment.setPaymentDate(loan.getTradeDate());
		interest = (principal*(details.getNoOfMonth()/12)*details.getInterestRate())/100;
		double  amount =interest;
		double evenPrincipal = details.getLoanAmount()/paymentSchedule;
		
		while(loan.getMaturityDate().compareTo(paymentDate)>0) 
		{
			if(details.getPaymentTeam().equalsIgnoreCase("Even principal"))
			{
				paymentDate = paymentDate.plusMonths(details.getPaymentFrequency());
				data1 = new PaymentSchedule(paymentDate, principal, interest, PaymentStatus.Projected, evenPrincipal+interest);
				principal-=evenPrincipal;
				interest = (principal*(details.getNoOfMonth()/12)*details.getInterestRate())/100;
				loan.getPaymentSchedule().add(data1);
				continue;
				
			}
			else if(details.getPaymentTeam().equalsIgnoreCase("Interest only"))
			{
				paymentDate = paymentDate.plusMonths(details.getPaymentFrequency());
				if(loan.getMaturityDate().compareTo(paymentDate)==0) amount =principal+interest;
				data1 = new PaymentSchedule(paymentDate, principal, interest, PaymentStatus.Projected, amount);
				loan.getPaymentSchedule().add(data1);
				continue;
			}
			else return "check the payment term";
		}
		newLoan.save(loan);
		return "Added for the new loan";
		
		
	}
	
	@Scheduled(cron = "0/15 * * * * *")
	public void UpdatePaymentSchedule() {
		LoanDetails loan = new LoanDetails();
		List<PaymentSchedule> data = schedule.findAll();
		
		for(PaymentSchedule i:data) 
		{
			if(i.getPaymentDate().compareTo(LocalDate.now())==0) i.setPaymentStatus(PaymentStatus.AwaitingPayment);
		}
		
		log.info("Payment Schedule {}"+data);
				
	}
	
	public List<LoanDetails> DisplayLoan()
	{
		List<LoanDetails> tempLoanDetails =newLoan.findAll();
		return tempLoanDetails;
	}

	public List<PaymentSchedule> DisplaySchedule() 
	{
		List<PaymentSchedule> data = schedule.findAll();
		return data; 
	}
}

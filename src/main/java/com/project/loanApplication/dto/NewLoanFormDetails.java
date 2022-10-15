package com.project.loanApplication.dto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewLoanFormDetails 
{
	@Positive (message = "0 and negative values are not allowed")
	private double loanAmount;
	@PositiveOrZero(message = "enter the number between 0-10")
	private int loanStartDate;
	@Positive (message = "0 and negative values are not allowed")
	private int paymentFrequency;
	@Positive (message = "0 and negative values are not allowed")
	private int interestRate;
	@Positive (message = "0 and negative values are not allowed")
	private int noOfMonth;
	private String paymentTeam;
}

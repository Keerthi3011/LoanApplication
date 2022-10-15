package com.project.loanApplication.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.project.loanApplication.entityEnum.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@Data
public class PaymentSchedule 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int payment_number;
	private LocalDate paymentDate;
	private double principal;
	private double projectedInterest;
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	private double paymentAmount;
	
	
	public PaymentSchedule(LocalDate paymentDate, double principal, double projectedInterest,
			PaymentStatus paymentStatus, double paymentAmount) {
		super();
		this.paymentDate = paymentDate;
		this.principal = principal;
		this.projectedInterest = projectedInterest;
		this.paymentStatus = paymentStatus;
		this.paymentAmount = paymentAmount;
	}

	
}

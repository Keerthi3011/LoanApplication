package com.project.loanApplication.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "loan_details")
public class LoanDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private double loanAmount;
	private LocalDate tradeDate;
	private LocalDate loanStartDate;
	private LocalDate maturityDate;
	private int paymentFrequency;
	private int interestRate;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn (name="customerId", referencedColumnName = "CustomerId")
	List <PaymentSchedule> paymentSchedule = new ArrayList<>();
}

package com.project.loanApplication.interfaces;

import java.util.List;

import com.project.loanApplication.entity.LoanDetails;
import com.project.loanApplication.entity.PaymentSchedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewLoanInterface extends JpaRepository<LoanDetails, Integer>
{

}
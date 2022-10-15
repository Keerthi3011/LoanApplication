package com.project.loanApplication.interfaces;

import java.util.List;

import com.project.loanApplication.entity.PaymentSchedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentScheduleInterface extends JpaRepository<PaymentSchedule, Integer>
{
	
}

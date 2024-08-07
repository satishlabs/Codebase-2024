package com.satishlabs.paymentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satishlabs.paymentservice.entity.Payment;
import com.satishlabs.paymentservice.repository.PaymentRepository;

import jakarta.transaction.Transactional;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;
	
	
	@Transactional
	public void processPayment(Payment payment) {
		payment.setStatus("COMPLETED");
		paymentRepository.save(payment);
	}
}

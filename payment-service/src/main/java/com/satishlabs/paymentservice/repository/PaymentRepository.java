package com.satishlabs.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.satishlabs.paymentservice.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}

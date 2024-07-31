package com.satishlabs.payment.service;

import com.satishlabs.payment.model.PaymentRequest;
import com.satishlabs.payment.model.PaymentStatus;

public interface PaymentService {
	PaymentStatus processPayment(PaymentRequest request);
	PaymentStatus checkPaymentStatus(String vendor,String transctionid);
}

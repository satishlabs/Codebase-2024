package com.satishlabs.payment.gateway;

import com.satishlabs.payment.model.PaymentRequest;
import com.satishlabs.payment.model.PaymentStatus;

public interface PaymentGateway {
	public PaymentStatus processRequest(PaymentRequest request);
	public PaymentStatus checkPaymentStatus(String transctionId);
}

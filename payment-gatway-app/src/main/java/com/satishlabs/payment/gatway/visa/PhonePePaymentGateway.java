package com.satishlabs.payment.gatway.visa;

import org.springframework.stereotype.Component;

import com.satishlabs.payment.gateway.PaymentGateway;
import com.satishlabs.payment.model.PaymentRequest;
import com.satishlabs.payment.model.PaymentStatus;

@Component
public class PhonePePaymentGateway implements PaymentGateway{

	@Override
	public PaymentStatus processRequest(PaymentRequest request) {
		//PhonePe payment processing logic
		PaymentStatus status = new PaymentStatus();
		status.setTranscationId("PhonePe1234");
		status.setStatus("Success");
		status.setMessage("Payment procssed successfully with PhonePe");
		return status;
	}

	@Override
	public PaymentStatus checkPaymentStatus(String transctionId) {
		//PhonePe payment status checking logic
		PaymentStatus status = new PaymentStatus();
		status.setTranscationId(transctionId);
		status.setStatus("Completed");
		status.setMessage("Payment status retrieved successfully for PhonePe");
		return status;
	}

}

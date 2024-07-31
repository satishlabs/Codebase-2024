package com.satishlabs.payment.gatway.visa;

import org.springframework.stereotype.Component;

import com.satishlabs.payment.gateway.PaymentGateway;
import com.satishlabs.payment.model.PaymentRequest;
import com.satishlabs.payment.model.PaymentStatus;

@Component
public class VisaPaymentGateway implements PaymentGateway{

	@Override
	public PaymentStatus processRequest(PaymentRequest request) {
		//Visa payment processing logic
		PaymentStatus status = new PaymentStatus();
		status.setTranscationId("VISA1234");
		status.setStatus("Success");
		status.setMessage("Payment processed successfully with Visa");
		return status;
	}

	@Override
	public PaymentStatus checkPaymentStatus(String transctionId) {
		//Visa payment status checking logic
		PaymentStatus status = new PaymentStatus();
		status.setTranscationId(transctionId);
		status.setStatus("Completed");
		status.setMessage("Payment status retrieved successfully for Visa");
		return status;
	}

}

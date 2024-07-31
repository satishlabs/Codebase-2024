package com.satishlabs.payment.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.satishlabs.payment.gateway.PaymentGateway;
import com.satishlabs.payment.gatway.visa.PhonePePaymentGateway;
import com.satishlabs.payment.gatway.visa.VisaPaymentGateway;

@Component
public class PaymentGatewayFactory {
	@Autowired
	private VisaPaymentGateway visaPaymentGateway;
	
	@Autowired
	private PhonePePaymentGateway phonePePaymentGateway;
	
	public PaymentGateway getPaymentGateway(String vendor) {
		switch (vendor.toLowerCase()) {
		case "visa": {
			return visaPaymentGateway;
		}
		case "phonepe":{
			return phonePePaymentGateway;
		}
		default:
			throw new IllegalArgumentException("Unsupported payment gateway: " + vendor);
		}
	}
}

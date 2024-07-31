package com.satishlabs.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satishlabs.payment.factory.PaymentGatewayFactory;
import com.satishlabs.payment.gateway.PaymentGateway;
import com.satishlabs.payment.model.PaymentRequest;
import com.satishlabs.payment.model.PaymentStatus;
import com.satishlabs.payment.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentGatewayFactory paymentGatewayFactory;

	@Override
	public PaymentStatus processPayment(PaymentRequest request) {
		PaymentGateway gateway = paymentGatewayFactory.getPaymentGateway(request.getVendor());
		return gateway.processRequest(request);
	}

	@Override
	public PaymentStatus checkPaymentStatus(String vendor, String transctionid) {
		PaymentGateway gateway = paymentGatewayFactory.getPaymentGateway(vendor);
		return gateway.checkPaymentStatus(transctionid);
	}
	
}

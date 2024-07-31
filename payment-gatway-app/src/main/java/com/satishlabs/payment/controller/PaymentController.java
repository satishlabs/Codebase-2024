package com.satishlabs.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satishlabs.payment.model.PaymentRequest;
import com.satishlabs.payment.model.PaymentStatus;
import com.satishlabs.payment.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	//http://localhost:8080/api/payments/process
	@PostMapping("/process")
	public ResponseEntity<PaymentStatus> processPayment(@RequestBody PaymentRequest request){
		PaymentStatus status = paymentService.processPayment(request);
		return ResponseEntity.ok(status);
	}
	
	//http://localhost:8080/api/payments/status/visa/VISA1234
	@GetMapping("/status/{vendor}/{transctionId}")
	public ResponseEntity<PaymentStatus> checkPaymentStatus(@PathVariable String vendor, @PathVariable String transctionId){
		PaymentStatus status = paymentService.checkPaymentStatus(vendor, transctionId);
		return ResponseEntity.ok(status);
	}
}

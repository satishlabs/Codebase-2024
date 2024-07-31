package com.satishlabs.payment.model;

public class PaymentStatus {
	private String transcationId;
	private String status;
	private String message;
	
	public String getTranscationId() {
		return transcationId;
	}
	public void setTranscationId(String transcationId) {
		this.transcationId = transcationId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "PaymentStatus [transcationId=" + transcationId + ", status=" + status + ", message=" + message
				+ ", getTranscationId()=" + getTranscationId() + ", getStatus()=" + getStatus() + ", getMessage()="
				+ getMessage() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}

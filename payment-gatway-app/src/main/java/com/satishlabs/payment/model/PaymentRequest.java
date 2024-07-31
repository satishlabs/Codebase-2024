package com.satishlabs.payment.model;

public class PaymentRequest {
	private String vendor;
    private String amount;
    private String currency;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "PaymentRequest [vendor=" + vendor + ", amount=" + amount + ", currency=" + currency + ", cardNumber="
				+ cardNumber + ", expiryDate=" + expiryDate + ", cvv=" + cvv + "]";
	}
    
    
}

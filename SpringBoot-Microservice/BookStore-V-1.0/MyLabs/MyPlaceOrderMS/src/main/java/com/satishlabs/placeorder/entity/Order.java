package com.satishlabs.placeorder.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "myorders", schema = "jlcordersdb")
@Schema(description = "Entity representing of orders detials")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderId_generator")
	@SequenceGenerator(name = "orderId_generator", sequenceName = "myorderId_gen", initialValue = 1003, allocationSize = 1)
	@Schema(description = "Unique identifier of the Order", example = "1")
	@Column(name = "order_id")
	private Integer orderId;

	@Schema(description = "Place order date", example = "15/08/2024")
	@Column(name = "order_date")
	private String orderDate;

	@Schema(description = "UserId", example = "U-11")
	@Column(name = "user_id")
	private String userId;

	@Schema(description = "Total order quantity", example = "4")
	@Column(name = "total_qty")
	private int totalQty;

	@Schema(description = "Total order cost", example = "4000")
	@Column(name = "total_cost")
	private double totalCost;

	@Schema(description = "order status", example = "New")
	@Column(name = "status")
	private String status;

	public Order() {
	}

	public Order(String orderDate, String userId, int totalQty, double totalCost, String status) {
		super();
		this.orderDate = orderDate;
		this.userId = userId;
		this.totalQty = totalQty;
		this.totalCost = totalCost;
		this.status = status;
	}

	public Order(Integer orderId, String orderDate, String userId, int totalQty, double totalCost, String status) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.userId = userId;
		this.totalQty = totalQty;
		this.totalCost = totalCost;
		this.status = status;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", userId=" + userId + ", totalQty="
				+ totalQty + ", totalCost=" + totalCost + ", status=" + status + "]";
	}

}

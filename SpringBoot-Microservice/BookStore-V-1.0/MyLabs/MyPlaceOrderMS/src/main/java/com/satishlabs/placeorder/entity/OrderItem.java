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
@Table(name = "myorderitems", schema = "jlcordersdb")
@Schema(description = "Entity representing of ordersItems detials")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderItemId_generator")
	@SequenceGenerator(name = "orderItemId_generator", sequenceName = "myorderItemId_gen", initialValue = 1, allocationSize = 1)
	@Schema(description = "Unique identifier of the OrderItem", example = "1")
	@Column(name = "order_item_id")
	private Integer orderItemId;

	@Schema(description = "Order Id", example = "U-11")
	@Column(name = "order_id")
	private Integer orderId;

	@Schema(description = "BookId", example = "104")
	@Column(name = "book_id")
	private Integer bookId;

	@Schema(description = "Book qauntity", example = "5")
	@Column(name = "qty")
	private int qty;

	@Schema(description = "Book cost", example = "500")
	@Column(name = "cost")
	private double cost;

	public OrderItem() {
	}

	public OrderItem(Integer orderId, Integer bookId, int qty, double cost) {
		super();
		this.orderId = orderId;
		this.bookId = bookId;
		this.qty = qty;
		this.cost = cost;
	}

	public OrderItem(Integer orderItemId, Integer orderId, Integer bookId, int qty, double cost) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.bookId = bookId;
		this.qty = qty;
		this.cost = cost;
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", bookId=" + bookId + ", qty=" + qty
				+ ", cost=" + cost + "]";
	}

}

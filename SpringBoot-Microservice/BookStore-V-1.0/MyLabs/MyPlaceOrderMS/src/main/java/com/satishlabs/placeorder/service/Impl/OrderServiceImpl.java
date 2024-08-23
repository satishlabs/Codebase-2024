package com.satishlabs.placeorder.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.satishlabs.placeorder.dto.OrderInfo;
import com.satishlabs.placeorder.entity.BookInventory;
import com.satishlabs.placeorder.entity.Order;
import com.satishlabs.placeorder.entity.OrderItem;
import com.satishlabs.placeorder.repository.BookInventoryDAO;
import com.satishlabs.placeorder.repository.OrderDAO;
import com.satishlabs.placeorder.repository.OrderItemDAO;
import com.satishlabs.placeorder.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private OrderItemDAO orderItemDAO;

	@Autowired
	private BookInventoryDAO bookInventoryDAO;

	@Override
	public void placeOrder(OrderInfo orderInfo) {
		logger.info("--- OrderServiceImpl ---  placeOrder() ---");

		// 1. Save the Order
		Order myorder = orderInfo.getOrder();
		myorder = orderDAO.save(myorder); // 1002
		int orderId = myorder.getOrderId();

		// 2. Save Order Items
		List<OrderItem> itemsList = orderInfo.getItemsList();
		for(OrderItem myorderItem : itemsList) {
			myorderItem.setOrderId(orderId);
			orderItemDAO.save(myorderItem);
		}

		// 3. Update Inventory at two places
		RestTemplate bookSearchRest = new RestTemplate();
		String endpoint = "http://localhost:8000/updateBookInventory";

		for(OrderItem myOrderItem: itemsList) {
			Integer bookId = myOrderItem.getBookId();
			BookInventory bookInventory = bookInventoryDAO.findById(bookId).get();
			Integer currentStock = bookInventory.getBooksAvailable();
			currentStock = currentStock - myOrderItem.getQty();
			bookInventory.setBooksAvailable(currentStock);

			//Local Inventory
			bookInventoryDAO.save(bookInventory);

			//BookSearchMS Inventory
			bookSearchRest.put(endpoint, bookInventory);
		}

	}

	@Override
	public List<Order> getOrdersByUserId(String userId) {
		logger.info("--- OrderServiceImpl ---  getOrdersByUserId() ---");
		List<Order> orderList = orderDAO.findOrdersByUserId(userId);
		return orderList;
	}

}

/**
 * 
 */
package com.ordermanagement.response;

import java.util.List;

import com.ordermanagement.entity.Order;
import com.ordermanagement.entity.OrderItem;
import com.ordermanagement.entity.Payment;

/**
 * Mar 29, 2020
 *
 * @author Tharunkumar Bairoju
 * 
 */
public class CartResponse {

	private Order order;
	private List<OrderItem> orderItems;
	private Payment paymentDetails;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Payment getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(Payment paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

}

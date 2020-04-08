/**
 * 
 */
package com.ordermanagement.request;

import java.util.List;

import com.ordermanagement.entity.Order;
import com.ordermanagement.entity.OrderItem;

/**
 * Mar 29, 2020
 *
 * @author Tharunkumar Bairoju
 * 
 */
public class AddToCartRequest {
	private Order order;
	private List<OrderItem> orderItems;

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

}

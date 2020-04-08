/**
 * 
 */
package com.ordermanagement.command.order;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanagement.command.Command;
import com.ordermanagement.constants.Constants;
import com.ordermanagement.entity.Order;
import com.ordermanagement.entity.OrderItem;
import com.ordermanagement.repository.OrderItemRepository;
import com.ordermanagement.repository.OrderRepository;
import com.ordermanagement.request.AddToCartRequest;
import com.ordermanagement.response.CartResponse;
import com.ordermanagement.response.Response;
import com.ordermanagement.service.ShoppingCartService;

/**
 * Mar 29, 2020
 *
 * @author Tharunkumar Bairoju
 * 
 */
@Service
public class AddProductsToCartCommand implements Command<AddToCartRequest, Response> {

	private static final Logger logger = LoggerFactory.getLogger(AddProductsToCartCommand.class);

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderItemRepository orderItemRepository;

	@Autowired
	ShoppingCartService shoppingCartService;

	@Override
	public Response execute(AddToCartRequest request) {

		try {
			BigDecimal totalAmount= new BigDecimal(0);
			Order order = request.getOrder();
			if (order != null) {
				order.setOrderStatus(Constants.IN_CART);
				List<OrderItem> items = request.getOrderItems();
				//totalAmount = items.stream().forEach(i -> totalAmount+i.getPricePerUnit());
				orderRepository.save(order);
				addOrderItems(items, order);
				CartResponse cart = new CartResponse();
				cart.setOrder(order);
				cart.setOrderItems(items);
				cart.setPaymentDetails(null);
				return new Response(Constants.SUCCESS, "Items added to cart", cart);
			}
		} catch (Exception e) {
			logger.error("Error while adding to cart" + e.getMessage());
		}
		return null;
	}

	public void addOrderItems(List<OrderItem> orderItems, Order order) {
		if (orderItems != null && !orderItems.isEmpty()) {
			for (OrderItem orderItem : orderItems) {
				orderItem.setOrder(order);
				orderItemRepository.save(orderItem);
			}
		}
	}

}

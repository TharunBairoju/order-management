/**
 * 
 */
package com.ordermanagement.command.order;

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
import com.ordermanagement.response.CartResponse;
import com.ordermanagement.response.Response;
import com.ordermanagement.service.ShoppingCartService;

/**
 * Mar 29, 2020
 *
 *	@author Tharunkumar Bairoju
 * 
 */
@Service
public class FetchCartDetailsCommand implements Command<Long, Response>{
	
	private static final Logger logger =  LoggerFactory.getLogger(FetchCartDetailsCommand.class);
	
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderItemRepository orderItemRepository;

	@Autowired
	ShoppingCartService shoppingCartService;

	@Override
	public Response execute(Long customerId) {
		try {
			Order order = orderRepository.findByCustomerIdAndOrderStatus(customerId, Constants.IN_CART);
			if(order != null) {
				List<OrderItem> orderItems = orderItemRepository.findByOrder(order);				
				CartResponse cart = new CartResponse();
				cart.setOrder(order);
				cart.setOrderItems(orderItems);
				cart.setPaymentDetails(null);
				return new Response(Constants.SUCCESS, "Cart items", cart);
			}
		} catch (Exception e) {
			logger.error("Error while fetching cart...!"+e.getMessage());
		}
		return null;
	}

}

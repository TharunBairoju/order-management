package com.ordermanagement.command.order;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanagement.command.Command;
import com.ordermanagement.entity.Order;
import com.ordermanagement.entity.OrderItem;
import com.ordermanagement.repository.OrderItemRepository;
import com.ordermanagement.repository.OrderRepository;
import com.ordermanagement.request.CartInfo;
import com.ordermanagement.request.UpdateCartRequest;
import com.ordermanagement.response.Response;

@Service
public class UpdateCartCommand implements Command<UpdateCartRequest, Response> {

	private static final Logger logger = LoggerFactory.getLogger(UpdateCartCommand.class);

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderItemRepository orderItemRepository;

	@Override
	public Response execute(UpdateCartRequest request) {
		try {
			Order order = orderRepository.findById(request.getOrderId()).get();
			if (request.getCartInfo() != null) {
				List<CartInfo> cartInfos = request.getCartInfo();
				for (CartInfo cartInfo : cartInfos) {
					if (cartInfo.isAdded()) {
						addProductToCart(request, cartInfo, order);
					} else if (cartInfo.isRemoved()) {
						removeProductFromCart(request, cartInfo, order);
					}
				}
			}
			return new Response("SUCCESS", "Cart updated..!", order);
		} catch (Exception e) {
			logger.error("Error while updating the order..!");
		}
		return null;
	}

	/**
	 * 
	 * @param request
	 * @param cartInfo
	 */
	private void removeProductFromCart(UpdateCartRequest request, CartInfo cartInfo, Order order) {
		try {
			OrderItem item = orderItemRepository.findByOrderAndProductId(order, cartInfo.getProductId());
			orderItemRepository.delete(item);
		} catch (Exception e) {
		}
	}

	/**
	 * 
	 * @param request
	 * @param cartInfo
	 */
	private void addProductToCart(UpdateCartRequest request, CartInfo cartInfo, Order order) {
		try {
			OrderItem item = new OrderItem();
			item.setCreatedAt(cartInfo.getCreatedAt());
			item.setCreatedBy(cartInfo.getCreatedBy());
			item.setLastUpdatedAt(cartInfo.getLastUpdatedAt());
			item.setLastUpdatedBy(cartInfo.getLastUpdatedBy());
			item.setOrder(order);
			item.setProductId(cartInfo.getProductId());
			item.setPricePerUnit(cartInfo.getPricePerUnit());
			item.setUnitId(cartInfo.getUnitId());
			orderItemRepository.save(item);
		} catch (Exception e) {
		}

	}

}

package com.ordermanagement.command.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanagement.command.Command;
import com.ordermanagement.constants.Constants;
import com.ordermanagement.entity.Order;
import com.ordermanagement.repository.OrderRepository;
import com.ordermanagement.response.Response;

@Service
public class CheckoutCartCommand implements Command<Long, Response>{

	private static final Logger logger = LoggerFactory.getLogger(CheckoutCartCommand.class);
	
	@Autowired
	OrderRepository orderRepository; 
	
	
	@Override
	public Response execute(Long customerId) {
		
		try {
			Order order = orderRepository.findByCustomerIdAndOrderStatus(customerId, Constants.IN_CART);
			
		} catch (Exception e) {
			logger.error("Error while checkout cart "+e.getMessage());
		}
		
		return null;
	}

}

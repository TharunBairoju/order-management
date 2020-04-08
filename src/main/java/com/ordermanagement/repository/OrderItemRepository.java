/**
 * 
 */
package com.ordermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ordermanagement.entity.Order;
import com.ordermanagement.entity.OrderItem;

/**
 * Mar 29, 2020
 *
 *	@author Tharunkumar Bairoju
 * 
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	/**
	 * @param order 
	 * @return
	 */
	List<OrderItem> findByOrder(Order order);

	OrderItem findByOrderAndProductId(Order order, Long productId);

}

/**
 * 
 */
package com.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ordermanagement.entity.Order;

/**
 * Mar 29, 2020
 *
 * @author Tharunkumar Bairoju
 * 
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	/**
	 * @param customerId
	 * @param inCart
	 * @return
	 */
	Order findByCustomerIdAndOrderStatus(Long customerId, String inCart);

}

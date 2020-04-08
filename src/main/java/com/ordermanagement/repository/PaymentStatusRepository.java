/**
 * 
 */
package com.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ordermanagement.entity.PaymentStatus;

/**
 * Mar 29, 2020
 *
 *	@author Tharunkumar Bairoju
 * 
 */
@Repository
public interface PaymentStatusRepository extends JpaRepository<PaymentStatus, Long>{

}

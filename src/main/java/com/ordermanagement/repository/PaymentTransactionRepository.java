/**
 * 
 */
package com.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ordermanagement.entity.PaymentTransaction;

/**
 * Mar 29, 2020
 *
 *	@author Tharunkumar Bairoju
 * 
 */
@Repository
public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long>{

}

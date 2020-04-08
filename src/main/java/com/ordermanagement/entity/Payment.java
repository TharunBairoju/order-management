/**
 * 
 */
package com.ordermanagement.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Mar 29, 2020
 *
 * @author Tharunkumar Bairoju
 * 
 */
@Entity
@Table(name = "payment")
public class Payment extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "order_id")
	private Long orderId;

	@Column(name = "total_amount")
	private BigDecimal totalAmount;

	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "payment_status_id")
	private Long paymentStatusId;

	@Column(name = "payment_method_id")
	private Long paymentMethodId;

	@Column(name = "is_serviceAppointment_required")
	private boolean serviceAppointmentRequired;

	public boolean isServiceAppointmentRequired() {
		return serviceAppointmentRequired;
	}

	public void setServiceAppointmentRequired(boolean serviceAppointmentRequired) {
		this.serviceAppointmentRequired = serviceAppointmentRequired;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getPaymentStatusId() {
		return paymentStatusId;
	}

	public void setPaymentStatusId(Long paymentStatusId) {
		this.paymentStatusId = paymentStatusId;
	}

	public Long getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(Long paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

}

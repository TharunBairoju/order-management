package com.ordermanagement.request;

import java.util.List;

public class UpdateCartRequest {

	private Long orderId;
	private Long customerId;
	private List<CartInfo> cartInfo;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<CartInfo> getCartInfo() {
		return cartInfo;
	}

	public void setCartInfo(List<CartInfo> cartInfo) {
		this.cartInfo = cartInfo;
	}

}

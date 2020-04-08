package com.ordermanagement.request;

import java.math.BigDecimal;
import java.util.Date;

public class CartInfo {

	private Long productId;
	private boolean added;
	private boolean removed;
	private Date createdAt;
	private Date lastUpdatedAt;
	private String createdBy;
	private String lastUpdatedBy;
	private BigDecimal pricePerUnit;
	private Long orderstatusId;
	private Long unitId;

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public Long getOrderstatusId() {
		return orderstatusId;
	}

	public void setOrderstatusId(Long orderstatusId) {
		this.orderstatusId = orderstatusId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public boolean isAdded() {
		return added;
	}

	public void setAdded(boolean added) {
		this.added = added;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void setRemoved(boolean removed) {
		this.removed = removed;
	}

}

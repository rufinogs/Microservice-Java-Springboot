package com.kairosds.practice.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class PriceAggregate{
	
	private Long brandId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Long productId;
	private Long priceList;
	private Integer priority;
	private Double price;
	private String curr;
	
	public PriceAggregate() {
		
	}
	
	public PriceAggregate(Long brandId, LocalDateTime startDate, LocalDateTime endDate, Long priceList,
			Long productId, Integer priority, Double price, String curr) {
		super();
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceList = priceList;
		this.productId = productId;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
	}
	

	public PriceAggregate(Long brandId, LocalDateTime startDate, LocalDateTime endDate, Long productId,
			Integer priority, Double price, String curr) {
		super();
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.productId = productId;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
	}

	public int hashCode() {
		return Objects.hash(brandId, curr, endDate, price, priceList, priority, productId, startDate);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriceAggregate other = (PriceAggregate) obj;
		return Objects.equals(brandId, other.brandId) && Objects.equals(curr, other.curr)
				&& Objects.equals(endDate, other.endDate) && Objects.equals(price, other.price)
				&& Objects.equals(priceList, other.priceList) && Objects.equals(priority, other.priority)
				&& Objects.equals(productId, other.productId) && Objects.equals(startDate, other.startDate);
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getPriceList() {
		return priceList;
	}

	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}
	
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	
	public LocalDateTime getStartDate() {
		return startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
}

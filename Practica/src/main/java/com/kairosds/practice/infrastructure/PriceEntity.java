package com.kairosds.practice.infrastructure;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NonNull;

@Entity
@Table(name = "PRICES")
public class PriceEntity{
	
	@NonNull
    @Column(name="BRAND_ID")
    private Long brandId;

    @NonNull
    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @NonNull
    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="PRICE_LIST")
    private Long priceList;

    @NonNull
    @Column(name="PRODUCT_ID")
    private Long productId;

    @NonNull
    @Column(name="PRIORITY")
    private Integer priority;

    @NonNull
    @Column(name="PRICE")
    private Double price;

    @NonNull
    @Column(name="CURR")
    private String currency;
    
    public PriceEntity() {
    	
    }

	public PriceEntity(@NonNull Long brandId, @NonNull LocalDateTime startDate, @NonNull LocalDateTime endDate,
			Long priceList, @NonNull Long productId, @NonNull Integer priority, @NonNull Double price,
			@NonNull String currency) {
		super();
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceList = priceList;
		this.productId = productId;
		this.priority = priority;
		this.price = price;
		this.currency = currency;
	}

	public PriceEntity(@NonNull Long brandId, @NonNull LocalDateTime startDate, @NonNull LocalDateTime endDate,
			@NonNull Long productId, @NonNull Integer priority, @NonNull Double price, @NonNull String currency) {
		super();
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.productId = productId;
		this.priority = priority;
		this.price = price;
		this.currency = currency;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriceEntity other = (PriceEntity) obj;
		return Objects.equals(brandId, other.brandId) && Objects.equals(currency, other.currency)
				&& Objects.equals(endDate, other.endDate) && Objects.equals(price, other.price)
				&& Objects.equals(priceList, other.priceList) && Objects.equals(priority, other.priority)
				&& Objects.equals(productId, other.productId) && Objects.equals(startDate, other.startDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(brandId, currency, endDate, price, priceList, priority, productId, startDate);
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Long getPriceList() {
		return priceList;
	}

	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
    
}

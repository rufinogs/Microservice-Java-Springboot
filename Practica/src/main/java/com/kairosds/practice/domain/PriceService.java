package com.kairosds.practice.domain;

import java.time.LocalDateTime;

public interface PriceService{
	
	public PriceAggregate findPriceListByProductIdAndBrandIdAndActualDate(Long productId, Long brandId, LocalDateTime actualDate);
	
}

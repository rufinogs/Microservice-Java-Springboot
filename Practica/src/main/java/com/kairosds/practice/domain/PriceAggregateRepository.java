package com.kairosds.practice.domain;

import java.util.List;

public interface PriceAggregateRepository {
	
	public List<PriceAggregate> findAll();
	
}


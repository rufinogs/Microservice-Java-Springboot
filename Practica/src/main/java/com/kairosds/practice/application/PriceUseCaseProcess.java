package com.kairosds.practice.application;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kairosds.practice.domain.PriceAggregate;
import com.kairosds.practice.domain.PriceService;
import com.kairosds.practice.infrastructure.PriceRepositoryDao;

@Service
public class PriceUseCaseProcess implements PriceService {
	
	@Autowired
	private PriceRepositoryDao priceRepositoryDao;
	
	public PriceUseCaseProcess(PriceRepositoryDao priceRepositoryDao) {
		this.priceRepositoryDao = priceRepositoryDao;
	}

	@Override
	public PriceAggregate findPriceListByProductIdAndBrandIdAndActualDate(Long productId, Long brandId, LocalDateTime actualDate) {
		
		List<PriceAggregate> selectedPrices = priceRepositoryDao.findAll();
		
		PriceAggregate finalPrice = selectedPrices.stream().
					filter(p -> p.getBrandId() == brandId).
					filter(p -> p.getStartDate().isBefore(actualDate)).
					filter(p -> p.getEndDate().isAfter(actualDate)).
					filter(p -> p.getProductId().equals(productId)).
					collect(Collectors.maxBy(Comparator.comparing(PriceAggregate :: getPriority))).
					stream().findFirst().get();
					
		return finalPrice;
	}
}		

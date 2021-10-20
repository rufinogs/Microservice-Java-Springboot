package com.kairosds.practice.infrastructure;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kairosds.practice.domain.PriceAggregate;
import com.kairosds.practice.domain.PriceAggregateRepository;

@Repository
public class PriceRepositoryDao implements PriceAggregateRepository{

	@Autowired
	PriceRepositoryImpl repositoryImpl;

	@Override
	public List<PriceAggregate> findAll() {
		ModelMapper modelMapper = new ModelMapper();
		List<PriceEntity> listPrice = repositoryImpl.findAll();
		List<PriceAggregate> returnList = listPrice
				.stream()
				.map(price -> modelMapper.map(price, PriceAggregate.class))
				.collect(Collectors.toList());
		return returnList;
	}

}

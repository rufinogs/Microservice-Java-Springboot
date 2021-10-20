package com.kairosds.practice.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kairosds.practice.domain.PriceAggregate;
import com.kairosds.practice.domain.PriceException;
import com.kairosds.practice.infrastructure.PriceRepositoryDao;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class PriceUseCaseProcessTest {
	
	@InjectMocks
	PriceUseCaseProcess useCase;
	
	@Mock
	PriceRepositoryDao priceRepo;

	@BeforeEach
	public void setUp() throws PriceException{
		MockitoAnnotations.openMocks(this);
		useCase = new PriceUseCaseProcess(priceRepo);
	}
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@Test
	public void testUseCase() {
		
		List<PriceAggregate> pricesExpect = new ArrayList<PriceAggregate>();
		
		PriceAggregate price1 = new PriceAggregate((long)1, LocalDateTime.parse("2020-06-14 00:00:00", formatter), LocalDateTime.parse("2020-12-31 23:59:59", formatter),(long)35455, 0, 35.50, "EUR");
		PriceAggregate price2 = new PriceAggregate((long)1, LocalDateTime.parse("2020-06-14 15:00:00", formatter), LocalDateTime.parse("2020-06-14 18:30:00", formatter),(long)35455, 1, 25.45, "EUR");
		PriceAggregate price3 = new PriceAggregate((long)1, LocalDateTime.parse("2020-06-15 00:00:00", formatter), LocalDateTime.parse("2020-06-15 11:00:00", formatter),(long)35455, 1, 30.50, "EUR");
		PriceAggregate price4 = new PriceAggregate((long)1, LocalDateTime.parse("2020-06-15 16:00:00", formatter), LocalDateTime.parse("2020-12-31 23:59:59", formatter),(long)35455, 1, 38.95, "EUR");
		
		pricesExpect.add(price1);
		pricesExpect.add(price2);
		pricesExpect.add(price3);
		pricesExpect.add(price4);
		
		when(priceRepo.findAll()).thenReturn(pricesExpect);
		
		PriceAggregate finalSearchedPrice = useCase.findPriceListByProductIdAndBrandIdAndActualDate((long)35455,(long)1, LocalDateTime.parse("2020-06-14 10:00:00", formatter));
		assertThat(finalSearchedPrice != null);
		assertThat(finalSearchedPrice.getProductId() == 35455);
		assertThat(finalSearchedPrice.getStartDate().equals(LocalDateTime.parse("2020-06-14 00:00:00", formatter)));
	}
}


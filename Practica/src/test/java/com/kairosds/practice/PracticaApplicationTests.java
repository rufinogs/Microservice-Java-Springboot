package com.kairosds.practice;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kairosds.practice.application.PriceUseCaseProcess;
import com.kairosds.practice.domain.PriceAggregate;

@SpringBootTest
class PracticaApplicationTests {
	
	@Autowired
	PriceUseCaseProcess useCase;
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	@Test
	public void findPriceListByProductIdAndBrandIdAndActualDate() {
		PriceAggregate priceExpected = new PriceAggregate((long)1, LocalDateTime.parse("2020-06-14 00:00:00", formatter), LocalDateTime.parse("2020-12-31 23:59:59", formatter),(long)1,(long) 35455, 0, 35.50, "EUR");
		LocalDateTime searchDate = LocalDateTime.parse("2020-06-14 10:00:00", formatter);
		PriceAggregate price = useCase.findPriceListByProductIdAndBrandIdAndActualDate((long)1, (long)35455, searchDate);
		assertEquals(priceExpected, price);
		
	}
}

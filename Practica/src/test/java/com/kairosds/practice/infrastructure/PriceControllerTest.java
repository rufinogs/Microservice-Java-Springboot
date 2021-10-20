package com.kairosds.practice.infrastructure;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kairosds.practice.application.PriceUseCaseProcess;
import com.kairosds.practice.domain.PriceAggregate;

@SpringBootTest
class PriceControllerTest {
	
	@Autowired
	PriceUseCaseProcess useCase;
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@Test
	//@org.junit.Test
	void findFirstByBrandProductDateTest1(){
		PriceAggregate priceExpected = new PriceAggregate((long)1, LocalDateTime.parse("2020-06-14 00:00:00", formatter), LocalDateTime.parse("2020-12-31 23:59:59", formatter),(long) 1, (long)35455, 0, 35.50, "EUR");
		LocalDateTime searchDate = LocalDateTime.parse("2020-06-14 10:00:00", formatter);
		PriceAggregate price = useCase.findPriceListByProductIdAndBrandIdAndActualDate((long)35455, (long)1, searchDate);
		assertEquals(priceExpected, price);
	}

	// Test 2: peticion a las 16:00 del día 14 del producto 35455  para la brand 1 (ZARA)
	@Test
	void findFirstByBrandProductDateTest2(){
		PriceAggregate priceExpected = new PriceAggregate((long)1, LocalDateTime.parse("2020-06-14 15:00:00", formatter), LocalDateTime.parse("2020-06-14 18:30:00", formatter), (long) 2, (long) 35455, 1, 25.45, "EUR");
		LocalDateTime searchDate = LocalDateTime.parse("2020-06-14 16:00:00", formatter);
		PriceAggregate price = useCase.findPriceListByProductIdAndBrandIdAndActualDate((long)35455, (long)1, searchDate);
		assertEquals(priceExpected, price);
	}

	// Test 3: peticion a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	@Test
	void findFirstByBrandProductDateTest3(){
		PriceAggregate priceExpected = new PriceAggregate((long)1, LocalDateTime.parse("2020-06-14 00:00:00", formatter), LocalDateTime.parse("2020-12-31 23:59:59", formatter),(long) 1,(long) 35455, 0, 35.50, "EUR");
		LocalDateTime searchDate = LocalDateTime.parse("2020-06-14 21:00:00", formatter);
		PriceAggregate price = useCase.findPriceListByProductIdAndBrandIdAndActualDate((long)35455, (long)1, searchDate);
		assertEquals(priceExpected, price);
	}

	// Test 4: peticion a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
	@Test
	void findFirstByBrandProductDateTest4(){
		PriceAggregate priceExpected = new PriceAggregate((long)1, LocalDateTime.parse("2020-06-15 00:00:00", formatter), LocalDateTime.parse("2020-06-15 11:00:00", formatter),(long) 3,(long) 35455, 1, 30.50, "EUR");
		LocalDateTime searchDate = LocalDateTime.parse("2020-06-15 10:00:00", formatter);
		PriceAggregate price = useCase.findPriceListByProductIdAndBrandIdAndActualDate((long)35455, (long)1, searchDate);
		assertEquals(priceExpected, price);
	}

	// Test 5: peticion a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
	@Test
	void findFirstByBrandProductDateTest5(){
		PriceAggregate priceExpected = new PriceAggregate((long)1, LocalDateTime.parse("2020-06-15 16:00:00", formatter), LocalDateTime.parse("2020-12-31 23:59:59", formatter),(long) 4,(long) 35455, 1, 38.95, "EUR");
		LocalDateTime searchDate = LocalDateTime.parse("2020-06-16 21:00:00", formatter);
		PriceAggregate price = useCase.findPriceListByProductIdAndBrandIdAndActualDate((long)35455, (long)1, searchDate);
		assertEquals(priceExpected, price);
	}
}

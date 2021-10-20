package com.kairosds.practice.infrastructure;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kairosds.practice.application.PriceUseCaseProcess;

@RestController
@RequestMapping("/apiprices")
public class PriceController {
	
	@Autowired
	PriceUseCaseProcess useCase;
	
	@Autowired 
	PriceRepositoryImpl repo;
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	
	@PostConstruct
	public void init() {
		repo.save(new PriceEntity((long)1, LocalDateTime.parse("2020-06-14 00:00:00", formatter), LocalDateTime.parse("2020-12-31 23:59:59", formatter),(long)35455, 0, 35.50, "EUR"));
		repo.save(new PriceEntity((long)1, LocalDateTime.parse("2020-06-14 15:00:00", formatter), LocalDateTime.parse("2020-06-14 18:30:00", formatter),(long)35455, 1, 25.45, "EUR"));
		repo.save(new PriceEntity((long)1, LocalDateTime.parse("2020-06-15 00:00:00", formatter), LocalDateTime.parse("2020-06-15 11:00:00", formatter),(long)35455, 1, 30.50, "EUR"));
		repo.save(new PriceEntity((long)1, LocalDateTime.parse("2020-06-15 16:00:00", formatter), LocalDateTime.parse("2020-12-31 23:59:59", formatter),(long)35455, 1, 38.95, "EUR"));
	}
	
	@GetMapping("/BrandAndProduct/{brandId}/{productId}")
	public ResponseEntity<PriceResponseDto> filteredPriceByBrandAndProductAndDate(@PathVariable long brandId, @PathVariable long productId,
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startDate){
		ModelMapper modelMapper = new ModelMapper();
		PriceResponseDto responsePrice = modelMapper.map(useCase.findPriceListByProductIdAndBrandIdAndActualDate(brandId, productId, startDate), PriceResponseDto.class);
		return new ResponseEntity<>(responsePrice, HttpStatus.OK);
	}

}

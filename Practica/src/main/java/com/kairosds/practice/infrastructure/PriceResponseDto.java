package com.kairosds.practice.infrastructure;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class PriceResponseDto {
	
	private Long brandId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Long productId;
	private Integer priority;
	private Double price;
	
}
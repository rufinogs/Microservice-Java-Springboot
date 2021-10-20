package com.kairosds.practice.infrastructure;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PriceRequestDto {
	
	 private Integer brandId;
	 private Integer productId;
	 private LocalDateTime actualDate;

}

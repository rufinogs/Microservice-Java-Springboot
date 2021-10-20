package com.kairosds.practice.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepositoryImpl extends JpaRepository<PriceEntity, Long> {

}

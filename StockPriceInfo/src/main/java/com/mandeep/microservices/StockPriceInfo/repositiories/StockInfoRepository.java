package com.mandeep.microservices.StockPriceInfo.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mandeep.microservices.StockPriceInfo.entities.StockInfo;

public interface StockInfoRepository extends JpaRepository<StockInfo, Integer>{

}

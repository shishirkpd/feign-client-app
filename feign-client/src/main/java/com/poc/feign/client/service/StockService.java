package com.poc.feign.client.service;

import com.poc.feign.client.model.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value="stockclient", url="http://localhost:8090/stock")
public interface StockService {

    @GetMapping("/")
    List<Stock> getAvailableStock();

    @GetMapping("/{symbol}")
    Stock getDetailsOfStock(@PathVariable String symbol);
}

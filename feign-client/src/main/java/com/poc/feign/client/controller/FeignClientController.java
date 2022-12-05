package com.poc.feign.client.controller;

import com.poc.feign.client.model.Stock;
import com.poc.feign.client.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
public class FeignClientController {
    @Autowired
    StockService stockService;


    @GetMapping("/stock")
    List<Stock> getAllAvailableStock() {
        return stockService.getAvailableStock();
    }

    @GetMapping("/stock/{symbol}")
    Stock getDetailsOfStock(@PathVariable String symbol) {
        var res =  stockService.getDetailsOfStock(symbol);
        log.info("res body: {}", res);
        return res;
    }
}

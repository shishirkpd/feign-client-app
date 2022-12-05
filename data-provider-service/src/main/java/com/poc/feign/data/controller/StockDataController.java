package com.poc.feign.data.controller;

import com.poc.feign.data.model.Stock;
import com.poc.feign.data.service.StockDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StockDataController {

    @Autowired
    StockDataService stockDataService;


    @GetMapping("/stock")
    ResponseEntity getAllSymbol() {
        var res = stockDataService.getAllStockSymbol();
        return new ResponseEntity(res, HttpStatus.OK);
    }

    @GetMapping("/stock/{symbol}")
    ResponseEntity getPriceForSymbol(@PathVariable String symbol) {
        try {
            Stock res = stockDataService.getStockPrice(symbol);
            return new ResponseEntity(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/stock/{symbol}")
    ResponseEntity addToWatchList(@PathVariable String symbol) {
        var res = stockDataService.addToWatchList(symbol);
        return new ResponseEntity(res, HttpStatus.OK);
    }
}

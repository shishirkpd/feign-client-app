package com.poc.feign.data.service;

import com.poc.feign.data.model.Stock;

import java.util.List;

public interface StockDataService {

    Stock getStockPrice(String symbol) throws Exception;

    List<Stock> getAllStockSymbol();

    List<Stock> addToWatchList(String symbol);
}

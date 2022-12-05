package com.poc.feign.data.service;

import com.poc.feign.data.model.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class StockDataServiceImpl implements StockDataService {
    private final List<String> allSymbols = List.of("Apple", "Tesla", "Google", "Amazon");

    double min = 10;
    double max = 200;
    private List<Stock> watchList = new ArrayList<>();
    @Override
    public Stock getStockPrice(String symbol) throws Exception {
        if(allSymbols.contains(symbol)) {
            return Stock.builder()
                    .name(symbol)
                    .price(min + (max - min) * new Random().nextDouble())
                    .build();
        } else throw new Exception("Given symbol: " + symbol + "not found");
    }

    @Override
    public List<Stock> getAllStockSymbol() {
        return allSymbols.stream().map(symbol ->
                Stock.builder()
                        .name(symbol)
                        .price(min + (max - min) * new Random().nextDouble())
                .build()).collect(Collectors.toList());
    }

    @Override
    public List<Stock> addToWatchList(String symbol) {
        if(allSymbols.contains(symbol)) {
            watchList.add(Stock.builder()
                    .name(symbol)
                    .price(min + (max - min) * new Random().nextDouble())
                    .build());
        };
        return watchList;
    }
}

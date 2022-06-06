package ru.saakian.dailyexchangerateanalyzer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class StockGifService {
    private final ProfitService profitService;
    private final GifLoaderService gifLoaderService;

    public ResponseEntity<byte[]> getFunnyGif(String currency) {
        boolean profit = profitService.isProfit(currency);
        return gifLoaderService.getActualGif(profit);
    }

}

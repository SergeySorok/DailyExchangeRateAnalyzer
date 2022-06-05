package ru.saakian.dailyexchangerateanalyzer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ExchangeRatesService {
    private final ProfitService profitService;
    private final GifGenerationService gifGenerationService;

    public ResponseEntity<byte[]> executor(String symbol) {
        boolean profit = profitService.isProfit(symbol);
        return gifGenerationService.getActualGif(profit);
    }

}

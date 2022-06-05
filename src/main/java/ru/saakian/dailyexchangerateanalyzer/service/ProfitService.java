package ru.saakian.dailyexchangerateanalyzer.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.saakian.dailyexchangerateanalyzer.feign.client.ExchangeRatesFeignClient;
import ru.saakian.dailyexchangerateanalyzer.feign.dto.CurrencyRateDto;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class ProfitService {
    private final ExchangeRatesFeignClient client;

    public boolean isProfit(String symbol) {
        CurrencyRateDto currencyRateDtoToday = client.latestRates("appId", "base", symbol);
        CurrencyRateDto currencyRateDtoYesterday = client.historicalRates("appId", symbol, "base", LocalDate.now().minusDays(1));

        return isExchangeRateProfit(symbol, currencyRateDtoToday, currencyRateDtoYesterday);
    }

    private boolean isExchangeRateProfit(String currency, CurrencyRateDto currencyRateDtoToday, CurrencyRateDto currencyRateDtoYesterday) {
        Double currencyToday = currencyRateDtoToday.getRate(currency);
        Double currencyYesterday = currencyRateDtoYesterday.getRate(currency);

        return currencyToday > currencyYesterday;
    }
}

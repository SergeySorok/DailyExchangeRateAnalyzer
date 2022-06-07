package ru.saakian.dailyexchangerateanalyzer.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.saakian.dailyexchangerateanalyzer.feign.client.ExchangeRatesFeignClient;
import ru.saakian.dailyexchangerateanalyzer.feign.dto.CurrencyRateDto;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class ProfitService {
    private final ExchangeRatesFeignClient client;

    @Value("${exchange-rates.app-id}")
    private String appId;
    @Value("${exchange-rates.base-currency}")
    private String baseCurrency;

    public boolean isProfit(String currency) {
        CurrencyRateDto currencyRateDtoToday = client.latestRates(appId, baseCurrency, currency);
        CurrencyRateDto currencyRateDtoYesterday = client.historicalRates(appId, currency, baseCurrency, LocalDate.now().minusDays(1));

        return isExchangeRateProfitable(currency, currencyRateDtoToday, currencyRateDtoYesterday);
    }

    private boolean isExchangeRateProfitable(String currency,
                                             CurrencyRateDto currencyRateDtoToday,
                                             CurrencyRateDto currencyRateDtoYesterday) {
        Double currencyToday = currencyRateDtoToday.getRate(currency);
        Double currencyYesterday = currencyRateDtoYesterday.getRate(currency);

        return currencyToday > currencyYesterday;
    }
}

//1. Проверить что вызываются клиенты (23-24 строки), 2. СОздать 2 DTO в котором карренси будет больше (вернет нужный булеан)
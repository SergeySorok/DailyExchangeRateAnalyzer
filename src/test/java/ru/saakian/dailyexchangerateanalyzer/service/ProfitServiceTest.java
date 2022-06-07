package ru.saakian.dailyexchangerateanalyzer.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.saakian.dailyexchangerateanalyzer.feign.client.ExchangeRatesFeignClient;
import ru.saakian.dailyexchangerateanalyzer.feign.dto.CurrencyRateDto;

import java.util.HashMap;

import static org.mockito.ArgumentMatchers.any;


@SpringBootTest
class ProfitServiceTest {

    @MockBean
    private ExchangeRatesFeignClient exchangeRatesFeignClient;

    private static CurrencyRateDto dtoWithRate(String currency, Double rate) {
        CurrencyRateDto currencyRateDto = new CurrencyRateDto();
        HashMap<String, Double> rates = new HashMap<>();
        rates.put(currency, rate);
        currencyRateDto.setRates(rates);
        return currencyRateDto;
    }

    @Test
    void isProfit_boolean() {

        String key = "RUB";
        Double lowerValue = 10.5;
        Double greaterValue = 34.7;

        CurrencyRateDto currencyRateDtoLowerValue = dtoWithRate(key, lowerValue);
        CurrencyRateDto currencyRateDtoGreaterValue = dtoWithRate(key, greaterValue);

        Mockito.when(exchangeRatesFeignClient.latestRates(any(), any(), any())).thenReturn(currencyRateDtoGreaterValue);
        Mockito.when(exchangeRatesFeignClient.historicalRates(any(), any(), any(), any())).thenReturn(currencyRateDtoLowerValue);
        ProfitService profitService = new ProfitService(exchangeRatesFeignClient);

        Assertions.assertTrue(profitService.isProfit(key));
    }
}
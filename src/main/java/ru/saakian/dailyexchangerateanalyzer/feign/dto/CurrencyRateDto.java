package ru.saakian.dailyexchangerateanalyzer.feign.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CurrencyRateDto {
    private String base;
    private Map<String, Double> rates;

    public Double getRate(String currency) {
        return rates.get(currency);
    }
}

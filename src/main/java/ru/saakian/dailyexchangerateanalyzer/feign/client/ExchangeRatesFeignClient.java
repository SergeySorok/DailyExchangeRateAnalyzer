package ru.saakian.dailyexchangerateanalyzer.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.saakian.dailyexchangerateanalyzer.feign.dto.CurrencyRateDto;

import java.time.LocalDate;

@FeignClient(value = "openexchangerates-api", url = "https://openexchangerates.org/api/")
public interface ExchangeRatesFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/historical/{date}.json")
    CurrencyRateDto historicalRates(@RequestParam("app_id") String appId,
                                    @RequestParam String symbols,
                                    @RequestParam String base,
                                    @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date);

    @RequestMapping(method = RequestMethod.GET, value = "/latest.json")
    CurrencyRateDto latestRates(@RequestParam("app_id") String appId,
                                @RequestParam String base,
                                @RequestParam String symbols);
}

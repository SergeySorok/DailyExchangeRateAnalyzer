package ru.saakian.dailyexchangerateanalyzer.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.saakian.dailyexchangerateanalyzer.service.ExchangeRatesService;

@Controller
@RequestMapping("/exchange")
@RequiredArgsConstructor
public class ExchangeRatesController {

    private final ExchangeRatesService exchangeRatesService;

    @GetMapping(produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> exchangeActualRates(@RequestParam String symbol) {
        return exchangeRatesService.executor(symbol);
    }
}


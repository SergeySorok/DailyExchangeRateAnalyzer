package ru.saakian.dailyexchangerateanalyzer.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.saakian.dailyexchangerateanalyzer.service.StockGifService;

@Controller
@RequestMapping("/funny-stock-gif")
@RequiredArgsConstructor
public class ExchangeRatesController {

    private final StockGifService stockGifService;

    @GetMapping(value = "/{currency}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> exchangeActualRates(@PathVariable String currency) {
        return stockGifService.getFunnyGif(currency);
    }
}


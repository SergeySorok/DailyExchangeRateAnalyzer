package ru.saakian.dailyexchangerateanalyzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import ru.saakian.dailyexchangerateanalyzer.feign.client.ExchangeRatesFeignClient;
import ru.saakian.dailyexchangerateanalyzer.feign.client.GiphyApiFeignClient;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableFeignClients
public class DailyExchangeRateAnalyzerApplication {

    @Autowired
    private ExchangeRatesFeignClient client;

    @Autowired
    private GiphyApiFeignClient gifClient;

    public DailyExchangeRateAnalyzerApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(DailyExchangeRateAnalyzerApplication.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        //  HistoricalDto historicalDto = client.historicalRates("58cae55fc6e144c0952e9966c472c8d6", "RUB", "USD", LocalDate.now());
        //  CurrencyRateDto latestDto = client.latestRates("58cae55fc6e144c0952e9966c472c8d6", "USD");
//        GifDto gifDto = gifClient.randomRichGif("q8yoq978BmhqkGoTw3nyO6bE9DNMdGEP", "broke", "g");
//        System.out.println(gifDto);
    }
}

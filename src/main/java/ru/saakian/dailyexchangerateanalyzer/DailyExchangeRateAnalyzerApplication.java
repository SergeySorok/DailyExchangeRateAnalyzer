package ru.saakian.dailyexchangerateanalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DailyExchangeRateAnalyzerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailyExchangeRateAnalyzerApplication.class, args);
    }
}

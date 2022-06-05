package ru.saakian.dailyexchangerateanalyzer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.saakian.dailyexchangerateanalyzer.feign.client.GiphyApiFeignClient;
import ru.saakian.dailyexchangerateanalyzer.feign.client.GiphyFeignClient;
import ru.saakian.dailyexchangerateanalyzer.feign.dto.GifDto;

@Component
@RequiredArgsConstructor
public class GifGenerationService {
    private final GiphyApiFeignClient gifClient;
    private final GiphyFeignClient giphyFeignClient;

    public ResponseEntity<byte[]> getActualGif(boolean isProfit) {

        String tag = isProfit ? "currency_appreciation" : "depreciation_of_the_currency";

        GifDto gifDto = gifClient.randomGif("app_key", tag);

        return giphyFeignClient.gifById(gifDto.getGifId());
    }
}

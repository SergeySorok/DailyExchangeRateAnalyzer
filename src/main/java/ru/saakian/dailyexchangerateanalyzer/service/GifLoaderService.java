package ru.saakian.dailyexchangerateanalyzer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.saakian.dailyexchangerateanalyzer.feign.client.GiphyApiFeignClient;
import ru.saakian.dailyexchangerateanalyzer.feign.client.GiphyFeignClient;
import ru.saakian.dailyexchangerateanalyzer.feign.dto.GifDto;

@Component
@RequiredArgsConstructor
public class GifLoaderService {
    private final GiphyApiFeignClient gifClient;
    private final GiphyFeignClient giphyFeignClient;

    @Value("${giphy.api.app-key}")
    private String appKey;

    @Value("${gif-service.tag.rich}")
    private String richTag;
    @Value("${gif-service.tag.broke}")
    private String brokeTag;

    public ResponseEntity<byte[]> getActualGif(boolean isProfit) {
        String tag = isProfit ? richTag : brokeTag;

        GifDto gifDto = gifClient.randomGif(appKey, tag);

        return giphyFeignClient.gifById(gifDto.getGifId());
    }
}

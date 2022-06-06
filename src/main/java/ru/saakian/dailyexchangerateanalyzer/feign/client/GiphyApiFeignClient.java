package ru.saakian.dailyexchangerateanalyzer.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.saakian.dailyexchangerateanalyzer.feign.dto.GifDto;

@FeignClient(value = "giphy-api", url = "${giphy.api.url}")
public interface GiphyApiFeignClient {

    @RequestMapping(method = RequestMethod.GET)
    GifDto randomGif(@RequestParam("api_key") String apiKey,
                     @RequestParam String tag);
}
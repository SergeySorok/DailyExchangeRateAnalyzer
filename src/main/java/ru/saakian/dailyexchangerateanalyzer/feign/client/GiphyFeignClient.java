package ru.saakian.dailyexchangerateanalyzer.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "giphy", url = "https://i.giphy.com/")
public interface GiphyFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "{id}.gif")
    ResponseEntity<byte[]> gifById(@PathVariable String id);
}
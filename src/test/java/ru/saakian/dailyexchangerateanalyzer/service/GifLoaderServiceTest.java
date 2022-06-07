package ru.saakian.dailyexchangerateanalyzer.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import ru.saakian.dailyexchangerateanalyzer.feign.client.GiphyApiFeignClient;
import ru.saakian.dailyexchangerateanalyzer.feign.client.GiphyFeignClient;
import ru.saakian.dailyexchangerateanalyzer.feign.dto.GifDto;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class GifLoaderServiceTest {

    @MockBean
    private GiphyApiFeignClient giphyApiFeignClient;

    @MockBean
    private GiphyFeignClient giphyFeignClient;

    @Test
    void getActualGif_callsService() {
        GifDto gifDto = new GifDto();
        gifDto.setData(new GifDto.Data());

        Mockito.when(giphyApiFeignClient.randomGif(any(), any())).thenReturn(gifDto);
        Mockito.when(giphyFeignClient.gifById(any())).thenReturn(ResponseEntity.ok(new byte[0]));

        new GifLoaderService(giphyApiFeignClient, giphyFeignClient).getActualGif(true);

        verify(giphyApiFeignClient, times(1)).randomGif(any(), any());
        verify(giphyFeignClient, times(1)).gifById(any());
    }
}
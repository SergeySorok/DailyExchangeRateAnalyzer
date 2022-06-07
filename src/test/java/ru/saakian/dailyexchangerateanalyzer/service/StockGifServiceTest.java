package ru.saakian.dailyexchangerateanalyzer.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class StockGifServiceTest {
    @MockBean
    private ProfitService profitService;
    @MockBean
    private GifLoaderService gifLoaderService;

    @Test
    void getFunnyGif_callsServices() {
        Mockito.when(profitService.isProfit(any())).thenReturn(true);
        Mockito.when(gifLoaderService.getActualGif(anyBoolean())).thenReturn(ResponseEntity.ok(new byte[0]));

        new StockGifService(profitService, gifLoaderService).getFunnyGif("");

        verify(profitService, times(1)).isProfit(any());
        verify(gifLoaderService, times(1)).getActualGif(anyBoolean());
    }
}

